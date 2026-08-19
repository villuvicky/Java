package arrays2;

import java.util.Scanner;

/*
 * Q1: Given an array, rotate it left or right by X positions IN-PLACE,
 * using only O(1) extra space (no second array), unlike
 * RotationArray.java (elsewhere in this batch), which solves the same
 * problem but needs a full extra array.
 *
 * Approach — the classic "reversal algorithm" for rotation:
 *   RIGHT rotation by x:
 *     1. Reverse the WHOLE array.
 *     2. Reverse just the first x elements.
 *     3. Reverse the remaining (len - x) elements.
 *   LEFT rotation by x:
 *     1. Reverse the WHOLE array.
 *     2. Reverse the first (len - x) elements.
 *     3. Reverse the last x elements.
 *
 * WHY THIS WORKS (right rotation intuition): reversing the whole array
 * flips everything's order, including flipping the "last x elements"
 * (which need to end up at the front) and the "first (len-x) elements"
 * (which need to end up at the back) — but each of those two chunks is
 * now internally backwards. Re-reversing each chunk individually
 * restores their internal order, while their POSITIONS (front chunk vs
 * back chunk) stay swapped from the very first full reversal — which is
 * exactly what a rotation needs.
 *
 * NOTE: this reuses the same reverse(A, left, right) helper seen in
 * Reversebw2index.java (elsewhere in this batch) — a good example of
 * how a single general-purpose "reverse a range" building block can
 * power a more advanced algorithm.
 *
 * IMPORTANT NOTE — SAME x > len RISK AS RotationArray.java: reverse()
 * is called with boundaries like (0, x-1) or (x, len-1). If x is larger
 * than len, "x-1" or "len-x-1" can produce an out-of-bounds or negative
 * index, throwing an exception — just like the modulo-based version.
 * Normalizing x first (e.g. "x = x % len;" before calling direction())
 * would guard against this here too.
 *
 * Trace for A = {1,2,3,4,5,6,7,8}, right rotation, x = 3:
 *   reverse(0,7): {8,7,6,5,4,3,2,1}
 *   reverse(0,2) [first x=3 elements]: {6,7,8,5,4,3,2,1}
 *   reverse(3,7) [remaining elements]: {6,7,8,1,2,3,4,5}
 *
 * Output: 6 7 8 1 2 3 4 5
 * (matches RotationArray.java's result for the same input — confirming
 * both approaches are correct, just with different space trade-offs)
 */
public class RotationArrayOptimized {
	
	
	public static void reverse(int A[],int left, int right) {
		while(left<right) {
		int temp=A[left];
		A[left]=A[right];
		A[right]=temp;
		left++;
		right--;
		}
	}

	public static void direction(int arr[], int rotation, int x) {
		int len=arr.length;
		if(rotation==1) {
			// right rotation: reverse all, then reverse each of the two chunks
			reverse(arr,0,len-1);
			reverse(arr, 0, x-1);
			reverse(arr, x, len-1);
		}
		else {
			// left rotation: reverse all, then reverse each of the two chunks
			reverse(arr,0,len-1);
			reverse(arr, 0, len-x-1);
			reverse(arr, len-x, len-1);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int A[]= {1,2,3,4,5,6,7,8};
		System.out.println("Enter 1 to right rotation and 0 to left");
		int rotation=sc.nextInt();

		System.out.println("Enter number of rotations");
		int x=sc.nextInt();
		
		direction(A, rotation, x);
		
		for (int i : A) {
			System.out.print(i+" ");
		}

	}

}