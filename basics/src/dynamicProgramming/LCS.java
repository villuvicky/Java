package dynamicProgramming;

import java.util.Scanner;

public class LCS {
	 public static int lcs(String s, String t) {
	        int m = s.length();
	        int n = t.length();

	        // dp[i][j] = LCS length of first i chars of s and first j chars of t
	        int[][] dp = new int[m + 1][n + 1];

	        // Fill DP table
	        for (int i = 1; i <= m; i++) {
	            for (int j = 1; j <= n; j++) {

	                // Characters match
	                if (s.charAt(i - 1) == t.charAt(j - 1)) {
	                    dp[i][j] = 1 + dp[i - 1][j - 1];
	                }
	                // Characters do not match
	                else {
	                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
	                }
	            }
	        }

	        return dp[m][n];
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Read two strings
	        String s = sc.nextLine();
	        String t = sc.nextLine();

	        // Print LCS length
	        System.out.println(lcs(s, t));

	        sc.close();
	    }
}
