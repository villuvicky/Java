package dynamicProgramming;

import java.util.Scanner;

public class FindWays {
	 static final int MOD = 1000000007;

	    public static int findWays(int[] arr, int k) {
	        int[] dp = new int[k + 1];

	        // One way to form sum 0: choose nothing
	        dp[0] = 1;

	        // Process each element
	        for (int num : arr) {
	            // Traverse backwards
	            for (int sum = k; sum >= num; sum--) {
	                dp[sum] = (dp[sum] + dp[sum - num]) % MOD;
	            }
	        }

	        return dp[k];
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        int n = sc.nextInt();
	        int k = sc.nextInt();

	        int[] arr = new int[n];
	        for (int i = 0; i < n; i++) {
	            arr[i] = sc.nextInt();
	        }

	        System.out.println(findWays(arr, k));

	        sc.close();
	    }
}
