package arrays;

import java.util.Scanner;

/*
 * Q1: Given an array of integers (read from input), find and return the
 * maximum (largest) element in the array.
 *
 * Approach: start by assuming the first element is the maximum, then
 * scan through every element and update the running maximum whenever a
 * larger value is found.
 *
 * NOTE: the "n" parameter passed into maximum_element() is never
 * actually used inside the method — the for-each loop relies entirely
 * on "arr" itself (which already knows its own length). This parameter
 * is redundant here and could be removed from the method signature
 * without changing behavior at all.
 *
 * NOTE: like most methods in this set of files, this assumes the array
 * is non-empty — arr[0] would throw an ArrayIndexOutOfBoundsException
 * if an empty array were passed in.
 *
 * Example:
 * Input:  n = 4, arr = [3, 7, 2, 9]
 * Output: 9
 */
public class MaximumNumber {


	public static int maximum_element(int[] arr, int n){
		
		int maximum=arr[0]; // start by assuming the first element is the max
		for (int i : arr) {
			if(i>maximum) {
				maximum=i;
			}
		}
		return maximum;
	}

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();

		int arr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(maximum_element(arr,n));
	}
}