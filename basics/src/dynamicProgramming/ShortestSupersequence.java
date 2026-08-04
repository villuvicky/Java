package dynamicProgramming;

import java.util.Scanner;

public class ShortestSupersequence {
	public static String shortestSupersequence(String a, String b) {
        int m = a.length();
        int n = b.length();

        // Step 1: Build LCS DP table
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Backtrack to build SCS
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            // Characters match
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                sb.append(a.charAt(i - 1));
                i--;
                j--;
            }
            // Move upward
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(a.charAt(i - 1));
                i--;
            }
            // Move left
            else {
                sb.append(b.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters from A
        while (i > 0) {
            sb.append(a.charAt(i - 1));
            i--;
        }

        // Add remaining characters from B
        while (j > 0) {
            sb.append(b.charAt(j - 1));
            j--;
        }

        // Reverse because we built it backwards
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read two strings
        String a = sc.nextLine();
        String b = sc.nextLine();

        // Print shortest common supersequence
        System.out.println(shortestSupersequence(a, b));

        sc.close();
    }
}
