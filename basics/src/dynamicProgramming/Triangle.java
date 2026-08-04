package dynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class Triangle {
	public static int minimumPathSum(ArrayList<ArrayList<Integer>> triangle, int n) {

        // DP table
        int[][] dp = new int[n][n];

        // Base case: copy the last row
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        // Fill from second last row upwards
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {

                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];

                dp[i][j] = Math.min(down, diagonal);
            }
        }

        // Final answer
        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of rows
        int n = sc.nextInt();

        // Read triangle
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                row.add(sc.nextInt());
            }

            triangle.add(row);
        }

        // Call function
        int result = minimumPathSum(triangle, n);

        // Print result
        System.out.println(result);

        sc.close();
    }
}
