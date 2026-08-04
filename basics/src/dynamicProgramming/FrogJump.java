package dynamicProgramming;

public class FrogJump {
	public static int frogJump(int n, int[] heights) {
        // Base case: already on first stair
        if (n == 1) {
            return 0;
        }

        // prev2 = dp[i-2], prev1 = dp[i-1]
        int prev2 = 0; // dp[0]
        int prev1 = 0; // dp[1] will be calculated in loop

        for (int i = 1; i < n; i++) {

            // Jump from previous stair
            int oneStep = prev1 + Math.abs(heights[i] - heights[i - 1]);

            // Jump from two stairs behind
            int twoStep = Integer.MAX_VALUE;
            if (i > 1) {
                twoStep = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }

            // Minimum energy to reach current stair
            int current = Math.min(oneStep, twoStep);

            // Shift for next iteration
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] heights = {10, 20, 30, 10};
        int n = heights.length;

        System.out.println(frogJump(n, heights)); // Output: 20
    }
}
