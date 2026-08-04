package dynamicProgramming;

import java.util.Scanner;

public class RodCutting {
	// Function to find maximum obtainable cost
    public static int cutRod(int[] price, int n) {
        // dp[i] = maximum cost obtainable from rod of length i
        int[] dp = new int[n + 1];

        // Base case: dp[0] = 0 (rod of length 0 has no value)
        dp[0] = 0;

        // Build the solution bottom-up
        for (int len = 1; len <= n; len++) {
            int maxValue = Integer.MIN_VALUE;

            // Try every possible first cut of size cut
            for (int cut = 1; cut <= len; cut++) {
                // price[cut - 1] because price uses 0-based indexing in Java
                maxValue = Math.max(maxValue,
                                    price[cut - 1] + dp[len - cut]);
            }

            dp[len] = maxValue;
        }

        // Maximum value for rod of length n
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read rod length
        int n = sc.nextInt();

        // Read prices for lengths 1 to n
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        // Print the maximum obtainable cost
        System.out.println(cutRod(price, n));

        sc.close();
    }
}
