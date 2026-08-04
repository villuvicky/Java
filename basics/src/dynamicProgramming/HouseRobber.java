package dynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class HouseRobber {

    // Solves the linear version of the problem
    public static long maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();

        // Edge case
        if (n == 0) {
            return 0;
        }

        // If only one element exists
        if (n == 1) {
            return nums.get(0);
        }

        // Space optimized DP
        long prev2 = nums.get(0); // dp[0]
        long prev1 = Math.max(nums.get(0), nums.get(1)); // dp[1]

        for (int i = 2; i < n; i++) {
            long pick = nums.get(i) + prev2;
            long notPick = prev1;

            long curr = Math.max(pick, notPick);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    // Main function for circular houses
    public static long houseRobber(ArrayList<Integer> valueInHouse) {
        int n = valueInHouse.size();

        // If only one house exists
        if (n == 1) {
            return valueInHouse.get(0);
        }

        ArrayList<Integer> first = new ArrayList<>();  // Exclude last house
        ArrayList<Integer> second = new ArrayList<>(); // Exclude first house

        for (int i = 0; i < n; i++) {
            if (i != n - 1) {
                first.add(valueInHouse.get(i));
            }

            if (i != 0) {
                second.add(valueInHouse.get(i));
            }
        }

        long ans1 = maximumNonAdjacentSum(first);
        long ans2 = maximumNonAdjacentSum(second);

        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of houses
        int n = sc.nextInt();

        // Read money in each house
        ArrayList<Integer> valueInHouse = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            valueInHouse.add(sc.nextInt());
        }

        // Call the function
        long result = houseRobber(valueInHouse);

        // Print result
        System.out.println(result);

        sc.close();
    }
}