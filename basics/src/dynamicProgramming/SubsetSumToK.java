package dynamicProgramming;

import java.util.Scanner;

public class SubsetSumToK {

    public static boolean subsetSumToK(int n, int k, int[] arr) {
        // dp[i][j] = whether sum j can be formed using first i elements
        boolean[][] dp = new boolean[n + 1][k + 1];

        // Sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int target = 1; target <= k; target++) {

                // Exclude current element
                dp[i][target] = dp[i - 1][target];

                // Include current element if possible
                if (arr[i - 1] <= target) {
                    dp[i][target] =
                        dp[i][target] ||
                        dp[i - 1][target - arr[i - 1]];
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(subsetSumToK(n, k, arr));

        sc.close();
    }
}
