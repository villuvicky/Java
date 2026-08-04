package dynamicProgramming;

import java.util.Scanner;

public class LongestPalinSubseq {
	 public static int longestPalinSubseq(String s) {
	        int n = s.length();

	        // Reverse the string
	        String rev = new StringBuilder(s).reverse().toString();

	        // dp[i][j] = LCS of first i chars of s and rev
	        int[][] dp = new int[n + 1][n + 1];

	        // Fill DP table
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= n; j++) {

	                // Characters match
	                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
	                    dp[i][j] = 1 + dp[i - 1][j - 1];
	                }
	                // Characters do not match
	                else {
	                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
	                }
	            }
	        }

	        return dp[n][n];
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        String s = sc.nextLine();

	        System.out.println(longestPalinSubseq(s));

	        sc.close();
	    }
}
