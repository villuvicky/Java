package arrays;

import java.util.Scanner;

/*
 * Q1: Given an array of integers (read from input), compute and return
 * the sum of all its elements.
 *
 * Approach: straightforward single-pass accumulation using a for-each
 * loop — the simplest possible array-processing pattern, and a good
 * building block that many other array problems (average, running
 * totals, prefix sums) extend from.
 *
 * NOTE: as with the other files in this set, this assumes "arr" is
 * non-null (a null array would throw a NullPointerException at the
 * for-each loop) — but an empty array is handled gracefully here
 * (the loop simply doesn't execute, and sum correctly returns 0).
 *
 * Example:
 * Input:  n = 4, arr = [3, 7, 2, 9]
 * Output: 21
 */
public class SumOfAllElements {
	
	
	public static int sum(int arr[]) {
		
		int sum=0;
		for (int i : arr) {
			sum=sum+i;
		}
		return sum;
	}

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();

		int arr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(sum(arr));
	}
}