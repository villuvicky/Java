package arrays;

import java.util.Scanner;

/*
 * Q1: Given an array of integers (read from input), find and return the
 * minimum (smallest) element in the array.
 *
 * Approach: mirror image of MaximumNumber.java — start by assuming the
 * first element is the minimum, then scan through every element and
 * update the running minimum whenever a smaller value is found.
 *
 * NOTE: unlike MaximumNumber.java (a companion file), this method
 * doesn't take an unused "n" parameter — it only takes "arr", which is
 * cleaner since arr.length already provides the size when needed. Worth
 * comparing the two signatures side by side.
 *
 * NOTE: like MaximumNumber.java, this assumes the array is non-empty —
 * arr[0] would throw an ArrayIndexOutOfBoundsException on an empty array.
 *
 * Example:
 * Input:  n = 4, arr = [3, 7, 2, 9]
 * Output: 2
 */
public class MinimumNumber {


	public static int minimum_element(int[] arr){
		
		int minimum=arr[0]; // start by assuming the first element is the min
		for (int i : arr) {
			if(i<minimum) {
				minimum=i;
			}
		}
		return minimum;
	}

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();

		int arr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(minimum_element(arr));
	}

}