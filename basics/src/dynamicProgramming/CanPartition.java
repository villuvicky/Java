package dynamicProgramming;

import java.util.Scanner;

public class CanPartition {
	 public static boolean canPartition(int[] arr, int n) {
	        // Step 1: Calculate total sum
	        int totalSum = 0;
	        for (int num : arr) {
	            totalSum += num;
	        }

	        // Step 2: If total sum is odd, partition is impossible
	        if (totalSum % 2 != 0) {
	            return false;
	        }

	        // Step 3: Target subset sum
	        int target = totalSum / 2;

	        // Step 4: 1D DP array
	        boolean[] dp = new boolean[target + 1];
	        dp[0] = true;

	        // Step 5: Process each number
	        for (int num : arr) {
	            // Traverse backwards to avoid using the same element twice
	            for (int sum = target; sum >= num; sum--) {
	                dp[sum] = dp[sum] || dp[sum - num];
	            }
	        }

	        // Final answer
	        return dp[target];
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        int n = sc.nextInt();
	        int[] arr = new int[n];

	        for (int i = 0; i < n; i++) {
	            arr[i] = sc.nextInt();
	        }

	        System.out.println(canPartition(arr, n));

	        sc.close();
	    }
}
