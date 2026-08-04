package dynamicProgramming;

public class FibonacciDP {

    // Returns nth Fibonacci number using Dynamic Programming (Tabulation)
    public static int fibonacci(int n) {
        // Base cases
        if (n <= 1) {
            return n;
        }

        // DP array to store Fibonacci values
        int[] dp = new int[n + 1];

        // Initialize base values
        dp[0] = 0;
        dp[1] = 1;

        // Fill the DP array
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Prints first n Fibonacci numbers
    public static void printFibonacciSeries(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static void main(String[] args) {
        int n = 10;
        printFibonacciSeries(n);
    }
}
