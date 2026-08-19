package arrays2;

import java.util.Scanner;

/*
 * Q1: Given an array, move all ZERO values to the END of the array
 * while preserving the relative order of the non-zero elements — the
 * classic "Move Zeroes" problem — in a single O(N) pass with O(1)
 * extra space.
 *
 * Approach: maintain two pointers — "nz" marks the next slot where a
 * non-zero value should go, and "z" scans through the array. Whenever
 * a non-zero value is found at "z", swap it into position "nz" and
 * advance "nz".
 *
 * NOTE ON ORDER PRESERVATION (in contrast with PushPositives.java):
 * this correctly preserves the relative order of the non-zero elements
 * — because "nz" only ever lags behind "z", any element sitting at
 * position "nz" waiting to be swapped out is guaranteed to already be
 * a zero that was skipped over earlier, so swapping never disturbs the
 * relative order of non-zero values as they get collected at the
 * front. This matches the general rule described in PushPositives.java:
 * the group being actively collected at the front (here, non-zero
 * values) keeps its order; only the group left behind (zeros here)
 * might end up reordered — though for zeros specifically, since they're
 * all the same value, "reordering" them is not observable anyway.
 *
 * Trace for A = {0, 1, 0, 3, 12} (nz=0, z=0):
 *   z=0: A[0]=0, skip
 *   z=1: A[1]=1 (non-zero) -> swap(1,0) -> {1,0,0,3,12}, nz=1
 *   z=2: A[2]=0, skip
 *   z=3: A[3]=3 (non-zero) -> swap(3,1) -> {1,3,0,0,12}, nz=2
 *   z=4: A[4]=12 (non-zero) -> swap(4,2) -> {1,3,12,0,0}, nz=3
 *
 * Output (final array): 1 3 12 0 0
 * (Non-zero elements 1, 3, 12 kept their original relative order;
 * both zeros ended up pushed to the back.)
 */
public class PushZero {

	public static void swap(int []A, int z, int nz) {
		int temp=A[z];
		A[z]=A[nz];
		A[nz]=temp;
	}

	public static void pushZeros(int []A) {
		int nz=0;
		int z=0;
		while(z<A.length) {
			if(A[z]!=0) {
				swap(A, z, nz);
				nz++;
			}
			z++;
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
		pushZeros(A);
		for (int i : A) {
			System.out.println(i+" ");
		}
	}
}