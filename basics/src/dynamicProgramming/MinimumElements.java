package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumElements {
	 public static int minimumElements(int[] arr, int x) {
	        int INF = Integer.MAX_VALUE / 2; // Prevent overflow
	        int[] dp = new int[x + 1];

	        // Initialize all sums as impossible
	        Arrays.fill(dp, INF);

	        // Base case
	        dp[0] = 0;

	        // Build DP table
	        for (int sum = 1; sum <= x; sum++) {
	            for (int coin : arr) {
	                if (coin <= sum) {
	                    dp[sum] = Math.min(dp[sum], 1 + dp[sum - coin]);
	                }
	            }
	        }

	        // If still INF, target cannot be formed
	        return dp[x] >= INF ? -1 : dp[x];
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Read N and X
	        int n = sc.nextInt();
	        int x = sc.nextInt();

	        // Read coin values
	        int[] arr = new int[n];
	        for (int i = 0; i < n; i++) {
	            arr[i] = sc.nextInt();
	        }

	        // Print answer
	        System.out.println(minimumElements(arr, x));

	        sc.close();
	    }
}
