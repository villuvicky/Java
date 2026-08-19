package arrays2;

import java.util.Scanner;

/*
 * Q1: Given a sorted array that has been rotated some unknown number of
 * times (e.g. [4,5,6,7,0,1,2] is [0,1,2,4,5,6,7] rotated by 4), find how
 * many rotations were performed — which is the same as finding the
 * INDEX of the minimum element.
 *
 * Approach: binary search. At each step, compare the middle element to
 * the element at "high". If arr[mid] > arr[high], the minimum must be
 * somewhere to the RIGHT of mid (mid itself can't be the minimum,
 * since it's still bigger than something later in the rotated array),
 * so move low to mid+1. Otherwise, the minimum is at mid OR to its
 * left, so move high down to mid (not mid-1, since mid itself could
 * still BE the minimum).
 *
 * IMPORTANT NOTE ON ASSUMPTIONS: this technique assumes the array has
 * NO DUPLICATE values. If duplicates are present (e.g. [2, 2, 2, 0, 1]),
 * comparing arr[mid] to arr[high] can become ambiguous — you can no
 * longer safely tell which half the minimum is in when arr[mid] ==
 * arr[high], and this binary search can give an incorrect result (or
 * you'd need extra handling, like shrinking "high" by 1 when values
 * are equal, which changes the complexity in the worst case). Always
 * check whether "distinct elements" is a safe assumption before relying
 * on this exact approach.
 *
 * IMPORTANT NOTE ON EFFICIENCY: this runs in O(log n) thanks to binary
 * search, compared to an O(n) linear scan for the minimum's index —
 * a good one to bring up if asked "can you do better than O(n)?" for
 * this kind of rotated-array problem.
 *
 * Trace for arr = [4, 5, 6, 7, 0, 1, 2] (low=0, high=6):
 *   mid=3: arr[3]=7 > arr[6]=2 -> low = 4
 *   mid=5: arr[5]=1 <= arr[6]=2 -> high = 5
 *   mid=4: arr[4]=0 <= arr[5]=1 -> high = 4
 *   low == high == 4 -> loop ends, return 4
 *
 * Output for this example: 4 (the array was rotated 4 times)
 */
public class CheckArrayRotation {

	 // Function to find rotation count (index of minimum element)
    public static int findRotationCount(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                // minimum is strictly to the right of mid
                low = mid + 1;
            } else {
                // minimum is at mid or to its left
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();   // number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();   // size of array
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(findRotationCount(arr));
        }
        sc.close();

	}

}