package arrays2;

import java.util.Arrays;

public class PairSum {

	/*
	 * Q1: Given a sorted array and a target sum "num", count the number
	 * of PAIRS (i, j) with i != j whose values sum to "num" — correctly
	 * handling duplicate values (e.g. if the same value appears
	 * multiple times, all valid pairings between occurrences should be
	 * counted).
	 *
	 * Approach: sort the array, then use two pointers starting at
	 * opposite ends. If the pair sum is too small, move "left" inward
	 * (to increase the sum); if too large, move "right" inward (to
	 * decrease it). When a match is found, there are two cases:
	 *   (a) arr[left] == arr[right] — meaning EVERY element in the
	 *       remaining [left..right] window is the same value (since the
	 *       array is sorted). Any two of them can pair up, so the count
	 *       of valid pairs is "n choose 2" where n is the window size:
	 *       count += n * (n - 1) / 2.
	 *   (b) arr[left] != arr[right] — count how many times each value
	 *       repeats (leftCount, rightCount), then every occurrence of
	 *       leftVal can pair with every occurrence of rightVal:
	 *       count += leftCount * rightCount.
	 *
	 * IMPORTANT NOTE: this exact duplicate-counting technique (the
	 * "n*(n-1)/2" combination formula for equal values, and
	 * "leftCount * rightCount" for distinct matching pairs) is reused
	 * again — extended to three numbers instead of two — in
	 * TripletSum.java's inner two-pointer loop. Recognizing this
	 * pattern is useful, since it generalizes cleanly from pairs to
	 * triplets (and beyond) once you fix the first element(s) and
	 * two-pointer the rest.
	 *
	 * IMPORTANT NOTE ON EFFICIENCY: this runs in O(n log n) overall
	 * (dominated by the sort), compared to findPair() below, which is
	 * O(n^2) brute force. Both are verified to agree on the same
	 * example below.
	 *
	 * Trace for arr = {3, 2, 3, 4} sorted -> {2, 3, 3, 4}, num = 6:
	 *   left=0(2), right=3(4): sum=6=num. Not equal. leftVal=2 (count 1),
	 *     rightVal=4 (count 1). count += 1*1 = 1. Now left=1, right=2.
	 *   left=1(3), right=2(3): sum=6=num. arr[left]==arr[right] (3==3).
	 *     window size = right-left+1 = 2. count += 2*1/2 = 1. Total = 2.
	 *
	 * Output: 2
	 */
	public static int pairSum(int[] arr, int num) {
	    Arrays.sort(arr);
	    int left = 0, right = arr.length - 1;
	    int count = 0;

	    while (left < right) {
	        int sum = arr[left] + arr[right];

	        if (sum < num) {
	            left++;
	        } else if (sum > num) {
	            right--;
	        } else {
	            // arr[left] + arr[right] == num

	            if (arr[left] == arr[right]) {
	                // every element left..right is identical -> "n choose 2" pairs
	                int n = right - left + 1;
	                count += (n * (n - 1)) / 2;
	                break;
	            }

	            int leftVal = arr[left];
	            int rightVal = arr[right];
	            int leftCount = 0, rightCount = 0;

	            while (left < right && arr[left] == leftVal) {
	                leftCount++;
	                left++;
	            }

	            while (right >= left && arr[right] == rightVal) {
	                rightCount++;
	                right--;
	            }

	            count += leftCount * rightCount;
	        }
	    }

	    return count;
	}

	/*
	 * Q2: Solve the same "count pairs summing to X" problem using a
	 * brute-force approach — check every possible pair.
	 *
	 * NOTE ON EFFICIENCY: this is O(n^2), the baseline that pairSum()
	 * above improves on using sorting + two pointers (O(n log n)). Both
	 * methods are called on the same input in main() below and agree on
	 * the answer (2), confirming pairSum()'s duplicate-handling logic is
	 * correct.
	 */
	 public static int findPair(int[] arr, int x) {
	        int n = arr.length;
	        int count = 0;

	        for (int i = 0; i < n - 1; i++) {
	            for (int j = i + 1; j < n ; j++) {
	                
	                    if (arr[i] + arr[j]  == x) {
	                        count++;
	                }
	            }
	        }
	        return count;
	    }

	public static void main(String[] args) {
		
		int [] arr=  {3, 2, 3, 4};
		int x=6;
		System.out.println(findPair(arr, x));
		System.out.println(pairSum(arr, x));
	}
}