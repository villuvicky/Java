package dynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class UniquePath {

	static final int MOD = 1000000007;

    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {

        // If start or destination is blocked
        if (mat.get(0).get(0) == -1 || mat.get(n - 1).get(m - 1) == -1) {
            return 0;
        }

        // DP table
        long[][] dp = new long[n][m];

        // Starting point
        dp[0][0] = 1;

        // Fill DP table
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // Skip starting cell
                if (i == 0 && j == 0) {
                    continue;
                }

                // Blocked cell
                if (mat.get(i).get(j) == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                long up = 0;
                long left = 0;

                // Ways from above
                if (i > 0) {
                    up = dp[i - 1][j];
                }

                // Ways from left
                if (j > 0) {
                    left = dp[i][j - 1];
                }

                // Total ways
                dp[i][j] = (up + left) % MOD;
            }
        }

        // Final answer
        return (int) dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read rows and columns
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Read maze into ArrayList<ArrayList<Integer>>
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                row.add(sc.nextInt());
            }

            mat.add(row);
        }

        // Call function
        int result = mazeObstacles(n, m, mat);

        // Print result
        System.out.println(result);

        sc.close();
    }
}
