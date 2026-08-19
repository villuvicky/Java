package arrays2;

import java.util.Scanner;

/*
 * Q1: Given an array, reverse it in-place using O(1) extra space.
 *
 * Approach: classic two-pointer swap — one pointer starts at the
 * beginning, one at the end, and they swap and move toward each other
 * until they meet or cross.
 *
 * NOTE: this is a specific (whole-array) case of the more general
 * "reverse a subrange" technique — see Reversebw2index.java (elsewhere
 * in this batch), which takes explicit left/right bounds instead of
 * always reversing the entire array. In fact, calling
 * Reversebw2index.reverse(A, 0, A.length - 1) would produce the exact
 * same result as this method. That same general reverse(left, right)
 * helper is also the key building block used inside
 * RotationArrayOptimized.java to rotate an array in O(1) extra space.
 *
 * Trace for A = {1, 2, 3, 4, 5} (left=0, right=4):
 *   swap A[0],A[4] -> {5,2,3,4,1}, left=1, right=3
 *   swap A[1],A[3] -> {5,4,3,2,1}, left=2, right=2
 *   left < right? 2 < 2 false -> loop ends
 *
 * Output: 5 4 3 2 1
 */
public class ReverseArray {
	
	public static void reverse(int [] A) {
		
		int right=A.length-1;
		int left=0;
		while(left<right) {
			
			int temp=A[left];
			A[left]=A[right];
			A[right]=temp;
			left++;
			right--;
		}
	}
	
	
	public static int takeInput(String str) {

		System.out.println(str);
		Scanner sc= new Scanner(System.in);
		return sc.nextInt();
	}

	public static void main(String[] args) {
		int capacity=takeInput("Enter capacity");

		int A[]=new int[capacity];

		for (int i=0; i<capacity;i++) {
			A[i]=takeInput("Enter value");
		}

		
		reverse(A);
		for (int i : A) {
			System.out.println(i+" ");
		}


	}

}