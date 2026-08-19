package arrays2;

import java.util.Scanner;

/*
 * Q1: Given an array and two indices "left" and "right", reverse only
 * the SUBRANGE of the array between those two indices (inclusive),
 * leaving everything outside that range untouched.
 *
 * NOTE: this generalizes ReverseArray.java's "reverse the whole array"
 * logic by accepting explicit boundaries instead of always using 0 and
 * (length-1). This exact reverse(A, left, right) helper is reused
 * directly inside RotationArrayOptimized.java (elsewhere in this
 * batch) as the core building block for its O(1)-extra-space "reversal
 * algorithm" approach to array rotation — reversing sub-ranges three
 * times in sequence is what allows rotation without any extra array.
 *
 * NOTE: no bounds validation is performed here — if "left" or "right"
 * fall outside the valid index range [0, A.length-1], or if left > right
 * in an unexpected way, this could throw an
 * ArrayIndexOutOfBoundsException rather than failing gracefully.
 *
 * Trace for A = {1, 2, 3, 4, 5}, left = 1, right = 3:
 *   swap A[1],A[3] -> {1,4,3,2,5}, left=2, right=2
 *   left < right? 2 < 2 false -> loop ends
 *
 * Output: 1 4 3 2 5
 * (only the middle section [index 1..3] was reversed; indices 0 and 4
 * were left untouched)
 */
public class Reversebw2index {

	public static void reverse(int [] A,int left,int right) {

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
		int left=takeInput("Enter left");
		int right=takeInput("Enter right");

		reverse(A,left,right);
		for (int i : A) {
			System.out.println(i+" ");
		}


	}

}