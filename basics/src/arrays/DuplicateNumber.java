package arrays;

import java.util.Scanner;

public class DuplicateNumber {

	/*
	 * Q1: Given an array, find and return a number that appears more
	 * than once (a duplicate), using a brute-force approach.
	 *
	 * Approach: for each element, count how many times it appears
	 * anywhere in the array (including itself); if that count is more
	 * than 1, it's a duplicate — return it immediately.
	 *
	 * NOTE: This returns the FIRST duplicate found by index order, not
	 * necessarily "the" duplicate if there are multiple different
	 * repeated values, and returns 0 if no duplicate exists at all
	 * (which is ambiguous if 0 could also be a legitimate array value —
	 * a sentinel like -1, or a boolean "found" flag, would be safer).
	 *
	 * IMPORTANT NOTE ON EFFICIENCY: this is O(n^2) — for every element,
	 * it re-scans the entire array. Compare this with findDuplicate()
	 * below, which solves a more specific version of this problem in
	 * O(n) time using XOR.
	 */
	public static int duplicate(int arr[]) {

		int n=arr.length;

		for(int i=0;i<n;i++) {
			int count=0;
			for(int j=0;j<n;j++) {
				if(arr[i]==arr[j])
					count++;
			}
			if(count>1) {
				//System.out.println(arr[i]);
				return arr[i];
			}
		}
		return 0;
		
	}
	

	/*
	 * Q2: Given an array of size N that contains every number from
	 * 0 to (N-2) exactly once, PLUS one number that is repeated an
	 * extra time (making the array N elements long overall), find that
	 * repeated (duplicate) number — but this time in O(N) time and O(1)
	 * extra space, using XOR.
	 *
	 * IMPORTANT NOTE: This technique only works because of the SPECIFIC
	 * structure assumed above (values 0..N-2, each appearing exactly
	 * once, with exactly one value appearing twice). It is NOT a
	 * general-purpose duplicate finder like duplicate() above — it
	 * would give a wrong answer on an arbitrary array that doesn't
	 * follow this pattern (e.g. multiple different duplicates, or
	 * values outside the 0..N-2 range).
	 *
	 * WHY IT WORKS: XOR-ing a value with itself cancels it out to 0
	 * (x ^ x = 0), and XOR-ing with 0 leaves a value unchanged
	 * (x ^ 0 = x). If you XOR together ALL elements of the array, every
	 * number in the 0..N-2 range that appears exactly once contributes
	 * itself once, and the duplicate value contributes itself TWICE more
	 * on top of its "regular" appearance — so:
	 *     XOR(array) = XOR(0..N-2) ^ duplicate
	 * XOR-ing that result with XOR(0..N-2) again cancels out the
	 * XOR(0..N-2) part entirely (since x ^ x = 0), leaving just the
	 * duplicate value by itself:
	 *     XOR(array) ^ XOR(0..N-2) = duplicate
	 *
	 * Trace for arr2 = {0, 1, 2, 3, 2} (N = 5, so expected range is 0..3):
	 *   XOR of array:       0^1^2^3^2 = 2
	 *   XOR of 0..N-2 (0..3): 2 ^ (0^1^2^3) = 2 ^ 0 = 2
	 *
	 * Output: 2
	 */
	    public static int findDuplicate(int[] arr) {
	        int xor = 0;

	        // XOR all elements of array
	        for (int num : arr) {
	            xor ^= num;
	        }

	        // XOR numbers from 0 to N-2 (see explanation above)
	        for (int i = 0; i <= arr.length - 2; i++) {
	            xor ^= i;
	        }

	        return xor;
	    }

	    
	     
	 

	public static void main(String[] args) {

		/*
		 * Scanner sc= new Scanner(System.in); int n=sc.nextInt();
		 * 
		 * int arr[]= new int[n];
		 * 
		 * for(int i=0;i<n;i++) { arr[i]=sc.nextInt(); } duplicate(arr);
		 */
		   int[] arr2 = {0, 1, 2, 3, 2};
	        System.out.println(findDuplicate(arr2)); // Output: 2
	}

}