package arrays2;

import java.util.Arrays;

/*
 * Q1: Given an array and a target sum X, count the number of triplets
 * (i, j, k) with i < j < k such that arr[i] + arr[j] + arr[k] == X —
 * correctly handling duplicate values — using an efficient sort +
 * two-pointer approach instead of brute force.
 *
 * Approach: sort the array first. Then fix one element at a time (i),
 * and use the SAME two-pointer + duplicate-counting technique from
 * PairSum.java's pairSum() method (elsewhere in this batch) on the
 * remaining subarray to count valid (left, right) pairs that complete
 * the triplet with arr[i]. This is essentially "PairSum, run once for
 * every choice of the first element."
 *
 * IMPORTANT NOTE ON EFFICIENCY: this brings the classic O(n^3)
 * brute-force triplet-counting problem (see CountTriplets.java,
 * elsewhere in this batch) down to O(n^2) after an initial O(n log n)
 * sort — a significant improvement, and a very common "how would you
 * optimize this?" follow-up in interviews after writing the naive
 * triple-nested-loop version.
 *
 * Trace for arr = {1, 2, 3, 4, 5, 6} (already sorted), x = 8:
 *   i=0 (value 1): two-pointer over {2,3,4,5,6} finds (1,2,5)=8 and
 *                  (1,3,4)=8 -> count = 2
 *   i=1 (value 2): no valid pair found in {3,4,5,6} summing to 6
 *   i=2 (value 3): no valid pair found in {4,5,6} summing to 5
 *   i=3 (value 4): no valid pair found in {5,6} summing to 4
 *   (verified against manual enumeration: only (1,2,5) and (1,3,4)
 *    sum to 8 among all triplets from {1..6})
 *
 * Output: 2
 */
public class TripletSum {

    public static int tripletSum(int[] arr, int x) {
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum < x) {
                    left++;
                } else if (sum > x) {
                    right--;
                } else {
                    // sum == x
                    if (arr[left] == arr[right]) {
                        // every element left..right is identical -> "n choose 2" pairs
                        int elements = right - left + 1;
                        count += (elements * (elements - 1)) / 2;
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
        }

        return count;
    }
    
    public static void main(String args[]) {
    	
    	int ARR []= {1, 2, 3, 4, 5, 6};
    			int X = 8;
    			System.out.println(tripletSum(ARR, X));

    }
}