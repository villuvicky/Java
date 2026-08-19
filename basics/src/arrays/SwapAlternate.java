package arrays;

import java.util.Scanner;

/*
 * Q1: Given an array, swap each pair of adjacent elements — i.e. swap
 * index 0 with index 1, index 2 with index 3, index 4 with index 5, and
 * so on — then print the resulting array.
 *
 * NOTE ON THE NAME "alternate": despite the method being named
 * "alternate", this doesn't swap alternating (every-other) elements
 * with each other — it swaps each CONSECUTIVE PAIR of elements (0<->1,
 * 2<->3, 4<->5, ...). A name like "swapAdjacentPairs" would more
 * accurately describe what it does.
 *
 * NOTE ON ODD-LENGTH ARRAYS: the loop condition is "i < n - 1", stepping
 * by 2 each time. If the array has an ODD number of elements, the very
 * last element has no partner to swap with and is simply left
 * untouched — this is correct/intentional behavior, not a bug, but
 * worth knowing so you don't expect the last element to move in that
 * case.
 *
 * Trace for arr = {1, 2, 3, 4, 5} (odd length, n=5):
 *   i=0: swap arr[0] and arr[1] -> {2, 1, 3, 4, 5}
 *   i=2: swap arr[2] and arr[3] -> {2, 1, 4, 3, 5}
 *   i=4: loop condition "4 < 4" is false -> loop stops, index 4 (value 5)
 *        is left untouched since it has no pair
 *
 * Output:
 * 2
 * 1
 * 4
 * 3
 * 5
 */
public class SwapAlternate {



	public static void alternate(int arr[]) {

		int n=arr.length;
	
			// swaps each consecutive pair: (0,1), (2,3), (4,5), ...
			for(int i=0;i<n-1;i+=2) {
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
			
			for (int i : arr) {
				System.out.println(i);
			}
		}
		
	
	public static void main(String[] args) {


		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();

		int arr[]= new int[n];

		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		alternate(arr);
	}

}