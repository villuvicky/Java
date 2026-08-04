package dynamicProgramming;

import java.util.Scanner;

public class CountPartitions {
	 static final int MOD = 1000000007;

	    public static int countPartitions(int n, int d, int[] arr) {
	        // Step 1: Calculate total sum
	        int totalSum = 0;
	        for (int num : arr) {
	            totalSum += num;
	        }

	        // Step 2: Check if partition is possible
	        if (totalSum - d < 0 || (totalSum - d) % 2 != 0) {
	            return 0;
	        }

	        // Step 3: Required subset sum
	        int target = (totalSum - d) / 2;

	        // Step 4: DP array
	        int[] dp = new int[target + 1];
	        dp[0] = 1; // One way to form sum 0

	        // Step 5: Count subsets with sum = target
	        for (int num : arr) {
	            // Traverse backwards to use each element only once
	            for (int sum = target; sum >= num; sum--) {
	                dp[sum] = (dp[sum] + dp[sum - num]) % MOD;
	            }
	        }

	        return dp[target];
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Number of test cases
	        int t = sc.nextInt();

	        while (t-- > 0) {
	            // Read N and D
	            int n = sc.nextInt();
	            int d = sc.nextInt();

	            // Read array
	            int[] arr = new int[n];
	            for (int i = 0; i < n; i++) {
	                arr[i] = sc.nextInt();
	            }

	            // Print answer for this test case
	            System.out.println(countPartitions(n, d, arr));
	        }

	        sc.close();
	    }
}
