package dynamicProgramming;

import java.util.Scanner;

public class ZeroOneKnapSack {
	public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        // DP table
        int[][] dp = new int[n][maxWeight + 1];

        // Base case: first item
        for (int w = weight[0]; w <= maxWeight; w++) {
            dp[0][w] = value[0];
        }

        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= maxWeight; w++) {

                // Option 1: Do not take current item
                int notTake = dp[i - 1][w];

                // Option 2: Take current item (if possible)
                int take = 0;
                if (weight[i] <= w) {
                    take = value[i] + dp[i - 1][w - weight[i]];
                }

                // Store the best choice
                dp[i][w] = Math.max(take, notTake);
            }
        }

        // Final answer
        return dp[n - 1][maxWeight];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of items
        int n = sc.nextInt();

        // Read weights
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        // Read values
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }

        // Read maximum capacity
        int maxWeight = sc.nextInt();

        // Call function
        int result = knapsack(weight, value, n, maxWeight);

        // Print result
        System.out.println(result);

        sc.close();
    }
}
