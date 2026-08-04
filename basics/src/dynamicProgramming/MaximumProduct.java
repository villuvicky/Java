package dynamicProgramming;

import java.util.Scanner;

public class MaximumProduct {
	 public static int maximumProduct(int[] arr, int n) {
	// Initialize with first element
    int maxProd = arr[0];
    int minProd = arr[0];
    int answer = arr[0];

    // Process remaining elements
    for (int i = 1; i < n; i++) {
        int num = arr[i];

        // If current number is negative, swap maxProd and minProd
        // because multiplying by a negative flips maximum and minimum.
        if (num < 0) {
            int temp = maxProd;
            maxProd = minProd;
            minProd = temp;
        }

        // Either start a new subarray from num,
        // or extend the previous subarray.
        maxProd = Math.max(num, num * maxProd);
        minProd = Math.min(num, num * minProd);

        // Update global maximum product.
        answer = Math.max(answer, maxProd);
    }

    return answer;
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Read size of array
    int n = sc.nextInt();

    // Read array elements
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }

    // Print maximum product subarray
    System.out.println(maximumProduct(arr, n));

    sc.close();
}
}
