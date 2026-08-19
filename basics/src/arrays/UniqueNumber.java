package arrays;

import java.util.Scanner;

public class UniqueNumber {

	/*
	 * Q1: Given an array, find and return a number that appears exactly
	 * ONCE (a "unique" element), using a brute-force approach — the
	 * mirror-image problem of DuplicateNumber.java's duplicate() method.
	 *
	 * Approach: for each element, count how many times it appears
	 * anywhere in the array (including itself); if that count is less
	 * than 2 (i.e. exactly 1), it's unique — print and return it.
	 *
	 * NOTE: this returns the FIRST unique value found by index order —
	 * if multiple different values each appear only once, only the
	 * first one encountered is reported, not all of them. It also
	 * returns 0 if no unique value exists at all, which is ambiguous if
	 * 0 could also be a legitimate array value.
	 *
	 * NOTE ON SIDE EFFECT: this method both PRINTS the result internally
	 * (System.out.println(arr[i])) AND returns it — unlike most other
	 * methods in this set of files (e.g. sum(), maximum_element()),
	 * which just return a value and let the caller decide whether/how to
	 * print it. This inconsistency means calling unique(arr) always
	 * prints as a side effect, which could be surprising if you only
	 * wanted the return value without any console output.
	 *
	 * IMPORTANT NOTE ON EFFICIENCY: this is O(n^2) — for every element,
	 * it re-scans the entire array. Compare this with unique2() below,
	 * which solves a more specific version of this problem in O(n) time
	 * using XOR — the same brute-force-vs-XOR contrast seen between
	 * duplicate() and findDuplicate() in DuplicateNumber.java.
	 */
	public static int unique(int arr[]) {

		int n=arr.length;

		for(int i=0;i<n;i++) {
			int count=0;
			for(int j=0;j<n;j++) {
				if(arr[i]==arr[j])
					count++;
			}
			if(count<2) {
				System.out.println(arr[i]);
				return arr[i];
			}
		}
		return 0;
		
		
	}
	
	/*
	 * Q2: Given an array where EVERY value appears exactly twice, except
	 * for exactly ONE value which appears only once, find that single
	 * unique value in O(N) time and O(1) extra space, using XOR (this is
	 * the classic "Single Number" problem).
	 *
	 * WHY IT WORKS: XOR-ing a value with itself cancels it out to 0
	 * (x ^ x = 0), and XOR is both commutative and associative, so the
	 * order of XOR-ing doesn't matter. If you XOR together every
	 * element of the array, every value that appears exactly TWICE
	 * cancels itself out completely (x ^ x = 0), leaving only the value
	 * that appears once — since XOR-ing anything with 0 leaves it
	 * unchanged (x ^ 0 = x).
	 *
	 * IMPORTANT NOTE: this technique assumes the SPECIFIC structure
	 * described above (every value appears exactly twice, except one).
	 * It is NOT a general-purpose "find any unique value" solution like
	 * unique() above — it would give an incorrect result on an array
	 * with a different pattern (e.g. multiple uniques, or a value
	 * appearing three or more times).
	 *
	 * Trace for arr = {2, 3, 2, 4, 4} (3 is the single unique value):
	 *   result = 0
	 *   0 ^ 2 = 2
	 *   2 ^ 3 = 1
	 *   1 ^ 2 = 3
	 *   3 ^ 4 = 7
	 *   7 ^ 4 = 3
	 *   final result = 3
	 */
	public static int unique2(int arr[]) {
		
		 int result = 0;

	        for (int num : arr) {
	            result^= num; // pairs cancel out to 0, leaving only the single unique value
	        }

	        return result;
	}

	public static void main(String[] args) {


		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();

		int arr[]= new int[n];

		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		unique(arr);
		System.out.println(unique2(arr));
	}

}