package dynamicProgramming;

import java.util.Scanner;

public class MinimumNumbrOfSquares {
	public static int minCount(int n) {
        // dp[i] = minimum number of squares needed to make i
        int[] dp = new int[n + 1];

        // Base case
        dp[0] = 0;

        // Fill dp array
        for (int i = 1; i <= n; i++) {
            // Worst case: all 1^2
            dp[i] = i;

            // Try all perfect squares <= i
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], 1 + dp[i - square]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(minCount(n));

        sc.close();
    }
}
