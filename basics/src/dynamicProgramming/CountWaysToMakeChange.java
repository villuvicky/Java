package dynamicProgramming;

import java.util.Scanner;

public class CountWaysToMakeChange {
	// Function to count the number of ways to make the given value
    public static long countWaysToMakeChange(int[] denominations, int value) {
        // dp[i] = number of ways to make sum i
        long[] dp = new long[value + 1];

        // Base case: there is exactly one way to make value 0
        // (choose no coins)
        dp[0] = 1;

        // Process each coin
        for (int coin : denominations) {
            // Update all sums that can be formed using this coin
            for (int amount = coin; amount <= value; amount++) {
                dp[amount] += dp[amount - coin];
            }
        }

        // Final answer
        return dp[value];
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input format:
        // First line: n (number of denominations)
        // Second line: n coin denominations
        // Third line: target value

        int n = sc.nextInt();

        int[] denominations = new int[n];
        for (int i = 0; i < n; i++) {
            denominations[i] = sc.nextInt();
        }

        int value = sc.nextInt();

        // Print the number of ways to make the target value
        System.out.println(countWaysToMakeChange(denominations, value));

        sc.close();
    }
}
