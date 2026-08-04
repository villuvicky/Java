package dynamicProgramming;

import java.util.Scanner;

public class CountMinStepsToOne {
	// Function to find minimum steps to reduce n to 1
    public static int countMinStepsToOne(int n) {
        // Initialize dp array inside the function so it is created
        // every time the function is called for a new test case.
        int[] dp = new int[n + 1];

        // Fill with -1 to indicate "not computed yet"
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        // Call helper function
        return helper(n, dp);
    }

    // Recursive helper with memoization
    private static int helper(int n, int[] dp) {
        // Base case
        if (n <= 1) {
            return 0;
        }

        // Return already computed result
        if (dp[n] != -1) {
            return dp[n];
        }

        // Option 1: Subtract 1
        int subtractOne = helper(n - 1, dp);

        // Option 2: Divide by 2
        int divideByTwo = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            divideByTwo = helper(n / 2, dp);
        }

        // Option 3: Divide by 3
        int divideByThree = Integer.MAX_VALUE;
        if (n % 3 == 0) {
            divideByThree = helper(n / 3, dp);
        }

        // Store and return minimum steps
        dp[n] = 1 + Math.min(subtractOne, Math.min(divideByTwo, divideByThree));
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(countMinStepsToOne(n));

        sc.close();
    }
}
