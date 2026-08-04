package dynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class MaximumProductSubArray {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {

		int maxProd = arr.get(0);   // Maximum product ending at current index
	    int minProd = arr.get(0);   // Minimum product ending at current index
	    int answer = arr.get(0);    // Overall maximum product found so far

	    // Traverse the array from index 1
	    for (int i = 1; i < n; i++) {
	        int num = arr.get(i);

	        // If current number is negative, swap maxProd and minProd
	        // because multiplying by a negative turns the largest into smallest
	        // and the smallest into largest.
	        if (num < 0) {
	            int temp = maxProd;
	            maxProd = minProd;
	            minProd = temp;
	        }

	        // Update maximum product ending at current index:
	        // 1. Start a new subarray with num
	        // 2. Extend previous maximum product subarray
	        maxProd = Math.max(num, num * maxProd);

	        // Update minimum product ending at current index:
	        // Needed because a negative number may turn it into the next maximum
	        minProd = Math.min(num, num * minProd);

	        // Update global answer
	        answer = Math.max(answer, maxProd);
	    }

	    return answer;
    }

    public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);

         // Read size of array
         int n = sc.nextInt();

         // Read elements into ArrayList
         ArrayList<Integer> arr = new ArrayList<>();
         for (int i = 0; i < n; i++) {
             arr.add(sc.nextInt());
         }

         // Print the maximum product subarray
         System.out.println(maximumProduct(arr, n));

         sc.close();
    }
}
