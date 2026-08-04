package dynamicProgramming;

import java.util.Scanner;

public class StairCase {
	public static long countDistinctWayToClimbStair(int nStairs) {
        int MOD = 1000000007;

        // Base cases
        if (nStairs == 0 || nStairs == 1) {
            return 1;
        }

        // ways(0) = 1, ways(1) = 1
        long prev2 = 1;
        long prev1 = 1;

        // Calculate ways from 2 to nStairs
        for (int i = 2; i <= nStairs; i++) {
            long current = (prev1 + prev2) % MOD;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of stairs
        int nStairs = sc.nextInt();

        // Output number of distinct ways
        System.out.println(countDistinctWayToClimbStair(nStairs));

        sc.close();
    }
}
