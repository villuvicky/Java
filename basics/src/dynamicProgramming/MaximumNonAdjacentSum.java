package dynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class MaximumNonAdjacentSum {

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();

        // Edge case: empty array
        if (n == 0) {
            return 0;
        }

        // If only one element exists
        if (n == 1) {
            return nums.get(0);
        }

        // dp[i] = maximum sum from index 0 to i
        int[] dp = new int[n];

        // Base cases
        dp[0] = nums.get(0);
        dp[1] = Math.max(nums.get(0), nums.get(1));

        // Fill DP array
        for (int i = 2; i < n; i++) {
            int pick = nums.get(i) + dp[i - 2];
            int notPick = dp[i - 1];

            dp[i] = Math.max(pick, notPick);
        }

        // Final answer
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read size of array
        int n = sc.nextInt();

        // Read array elements into ArrayList
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }

        // Call the function
        int result = maximumNonAdjacentSum(nums);

        // Print the result
        System.out.println(result);

        sc.close();
    }
}
