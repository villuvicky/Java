package dynamicProgramming;

import java.util.Scanner;

public class MatrixMultiplication {

    public static int matrixMultiplication(int[] arr, int n) {
        // dp[i][j] = minimum cost to multiply matrices i..j
        int[][] dp = new int[n][n];

        // Single matrix => no cost
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // chainLen = number of matrices in the chain
        for (int chainLen = 2; chainLen < n; chainLen++) {

            for (int i = 1; i <= n - chainLen; i++) {
                int j = i + chainLen - 1;

                dp[i][j] = Integer.MAX_VALUE;

                // Try every split point
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k]
                             + dp[k + 1][j]
                             + arr[i - 1] * arr[k] * arr[j];

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        // Minimum cost to multiply A1 to A(n-1)
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Length of dimension array
        int n = sc.nextInt();

        // Read dimensions
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Print minimum multiplication cost
        System.out.println(matrixMultiplication(arr, n));

        sc.close();
    }
}
