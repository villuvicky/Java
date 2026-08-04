package dynamicProgramming;

import java.util.Scanner;

public class TargetSum {
	  public static int targetSum(int n, int target, int[] arr) {
		// Step 1: Calculate total sum of all elements
	        int totalSum = 0;
	        for (int num : arr) {
	            totalSum += num;
	        }

	        /*
	         * Let:
	         * S1 = sum of elements assigned '+'
	         * S2 = sum of elements assigned '-'
	         *
	         * Then:
	         * S1 - S2 = target
	         * S1 + S2 = totalSum
	         *
	         * Adding both equations:
	         * 2 * S1 = totalSum + target
	         * S1 = (totalSum + target) / 2
	         *
	         * So the problem becomes:
	         * Count the number of subsets with sum = requiredSum.
	         */

	        // Step 2: Check if solution is possible
	        if (totalSum < Math.abs(target)) {
	            return 0;
	        }

	        if ((totalSum + target) % 2 != 0) {
	            return 0;
	        }

	        // Step 3: Required subset sum
	        int requiredSum = (totalSum + target) / 2;

	        // Step 4: dp[s] = number of ways to form sum s
	        int[] dp = new int[requiredSum + 1];

	        // Base case: One way to form sum 0 (choose nothing)
	        dp[0] = 1;

	        // Step 5: Process each element
	        for (int num : arr) {
	            // Traverse backwards so each element is used only once
	            for (int sum = requiredSum; sum >= num; sum--) {
	                dp[sum] += dp[sum - num];
	            }
	        }

	        // Final answer
	        return dp[requiredSum];
	    }
	    

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        int n = sc.nextInt();
	        int target = sc.nextInt();

	        int[] arr = new int[n];
	        for (int i = 0; i < n; i++) {
	            arr[i] = sc.nextInt();
	        }

	        System.out.println(targetSum(5,target, arr));

	        sc.close();
	    }
}
