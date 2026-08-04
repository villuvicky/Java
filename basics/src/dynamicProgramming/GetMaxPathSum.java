package dynamicProgramming;

import java.util.Scanner;

public class GetMaxPathSum {
	public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // DP table
        int[][] dp = new int[n][m];

        // Base case: last row remains the same
        for (int j = 0; j < m; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }

        // Fill the DP table from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {

                // Move Down
                int down = matrix[i][j] + dp[i + 1][j];

                // Move Down-Left
                // If column is invalid, use a very small value
                int downLeft = Integer.MIN_VALUE;
                if (j > 0) {
                    downLeft = matrix[i][j] + dp[i + 1][j - 1];
                }

                // Move Down-Right
                int downRight = Integer.MIN_VALUE;
                if (j < m - 1) {
                    downRight = matrix[i][j] + dp[i + 1][j + 1];
                }

                // Take maximum of all three choices
                dp[i][j] = Math.max(down, Math.max(downLeft, downRight));
            }
        }

        // Answer = maximum value in the first row
        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            ans = Math.max(ans, dp[0][j]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of test cases
        int t = sc.nextInt();

        while (t-- > 0) {
            // Read dimensions
            int n = sc.nextInt();
            int m = sc.nextInt();

            // Read matrix
            int[][] matrix = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Print result for each test case
            System.out.println(getMaxPathSum(matrix));
        }

        sc.close();
    }
}
