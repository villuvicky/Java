package arrays2;

/*
 * Q1: Given an array and a target sum X, count the number of triplets
 * (i, j, k) with i < j < k such that arr[i] + arr[j] + arr[k] == X.
 *
 * NOTE: This is the exact same problem and implementation already
 * covered earlier in this conversation (in the "arrays2" package, same
 * class name), just re-confirmed here as part of this batch. See that
 * earlier version for the full breakdown — in short: this is the
 * brute-force O(n^3) approach (three nested loops checking every
 * possible triplet), and TripletSum.java (elsewhere in this batch)
 * solves the same kind of problem in O(n^2) using sorting + two
 * pointers, with extra handling for duplicate values.
 *
 * Trace for arr = {1, 2, 3, 4}, x = 6:
 *   Only (arr[0], arr[1], arr[2]) = (1, 2, 3) sums to 6.
 *
 * Output: 1
 */
public class CountTriplets {
	
	
	 public static int findTriplet(int[] arr, int x) {
	        int n = arr.length;
	        int count = 0;

	        for (int i = 0; i < n - 2; i++) {
	            for (int j = i + 1; j < n - 1; j++) {
	                for (int k = j + 1; k < n; k++) {
	                    if (arr[i] + arr[j] + arr[k] == x) {
	                        count++;
	                    }
	                }
	            }
	        }
	        return count;
	    }

	public static void main(String[] args) {
		
		int [] arr=  {1, 2, 3, 4};
		int x=6;
		System.out.println(findTriplet(arr, x));

	}

}