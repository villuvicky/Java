package arrays2;

/*
 * Q1: Given an array, find the "equilibrium index" — an index i where
 * the sum of all elements to its LEFT equals the sum of all elements to
 * its RIGHT (the element at index i itself is excluded from both
 * sides). Return -1 if no such index exists.
 *
 * Approach: first compute the total sum of the whole array once. Then
 * walk through the array keeping a running "leftSum". At each index,
 * the right-hand sum can be computed WITHOUT re-scanning the rest of
 * the array, using: rightSum = totalSum - leftSum - arr[i] (i.e.
 * "everything else" minus what's already counted on the left minus the
 * current element itself).
 *
 * IMPORTANT NOTE ON EFFICIENCY: computing rightSum this way (via simple
 * subtraction) is what makes this an O(n) solution overall. A naive
 * approach that re-sums the right-hand side from scratch for every
 * index would be O(n^2) instead.
 *
 * Trace for arr = {1, 4, 9, 3, 2} (totalSum = 19):
 *   i=0: rightSum = 19 - 0 - 1 = 18. leftSum(0) != rightSum(18). leftSum becomes 1.
 *   i=1: rightSum = 19 - 1 - 4 = 14. leftSum(1) != rightSum(14). leftSum becomes 5.
 *   i=2: rightSum = 19 - 5 - 9 = 5.  leftSum(5) == rightSum(5)! -> return 2.
 *
 * Output: 2
 */
public class EquilibirumIndex {
	public static int equilibriumIndex(int[] arr) {
	    int totalSum = 0;

	    for (int num : arr) {
	        totalSum += num;
	    }

	    int leftSum = 0;

	    for (int i = 0; i < arr.length; i++) {
	        // rightSum computed via subtraction, avoiding a second full scan
	        int rightSum = totalSum - leftSum - arr[i];

	        if (leftSum == rightSum) {
	            return i;
	        }

	        leftSum += arr[i];
	    }

	    return -1; // no equilibrium index exists
	}


	public static void main(String[] args) {
		
		System.out.println(equilibriumIndex(new int []{1,4,9,3,2}));

	}

}