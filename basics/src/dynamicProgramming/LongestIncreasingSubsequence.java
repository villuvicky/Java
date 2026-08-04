package dynamicProgramming;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
	public static int longestIncreasingSubsequence(int[] arr) {
		  int n = arr.length;

	        if (n == 0) {
	            return 0;
	        }

	        // tails[i] = smallest ending value of an increasing subsequence of length i+1
	        int[] tails = new int[n];
	        int size = 0;

	        for (int num : arr) {
	            int left = 0;
	            int right = size;

	            // Binary search for first index where tails[mid] >= num
	            while (left < right) {
	                int mid = left + (right - left) / 2;

	                if (tails[mid] < num) {
	                    left = mid + 1;
	                } else {
	                    right = mid;
	                }
	            }

	            // Replace or append
	            tails[left] = num;

	            // If inserted at the end, increase size
	            if (left == size) {
	                size++;
	            }
	        }

	        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read size
        int n = sc.nextInt();

        // Read array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Print LIS length
        System.out.println(longestIncreasingSubsequence(arr));

        sc.close();
    }
}
