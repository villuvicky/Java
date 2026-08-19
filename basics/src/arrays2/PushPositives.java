package arrays2;

import java.util.Scanner;

/*
 * Q1: Given an array, rearrange it in-place so that all negative
 * numbers come before all non-negative numbers, using a single O(N)
 * pass and O(1) extra space.
 *
 * Approach: maintain two pointers — "n" marks the next slot where a
 * negative number should go, and "p" scans through the array. Whenever
 * a negative number is found at "p", swap it into position "n" and
 * advance "n".
 *
 * IMPORTANT NAMING NOTE: despite the method being called
 * "pushPositives", this ACTUALLY pushes NEGATIVE numbers to the FRONT
 * of the array (leaving positive/non-negative numbers at the back) —
 * the opposite of what the name suggests. If the intent really was to
 * push positives to the front instead, the condition would need to be
 * "A[p] >= 0" (or ">0" depending on how you want to treat zero), not
 * "A[p] < 0". Worth renaming this method (e.g. to "pushNegatives") to
 * match its actual behavior, or fixing the condition if the name was
 * the intended behavior.
 *
 * IMPORTANT NOTE ON ORDER PRESERVATION: this partitioning technique
 * preserves the RELATIVE ORDER of the negative numbers (the group
 * being moved to the front), but does NOT guarantee the relative order
 * of the positive numbers left behind — they can end up shuffled
 * relative to their original order, because they get swapped out of
 * position unpredictably as negatives are pulled forward. Compare this
 * with PushZero.java (elsewhere in this batch), which uses the exact
 * same swapping pattern but happens to preserve the order of ITS
 * "front" group (non-zero elements) — the general rule is: the group
 * being actively collected at the front keeps its order, but the group
 * left behind might not.
 *
 * Trace for A = {-1, 2, -3, 4, -5} (n=0, p=0):
 *   p=0: A[0]=-1<0 -> swap(0,0) [no-op], n=1
 *   p=1: A[1]=2, not negative, skip
 *   p=2: A[2]=-3<0 -> swap(2,1) -> {-1,-3,2,4,-5}, n=2
 *   p=3: A[3]=4, not negative, skip
 *   p=4: A[4]=-5<0 -> swap(4,2) -> {-1,-3,-5,4,2}, n=3
 *
 * Output (final array): -1 -3 -5 4 2
 * (Negatives -1,-3,-5 keep their original relative order. Positives
 * ended up as 4,2 — reversed from their original order of 2,4.)
 */
public class PushPositives {

	public static void swap(int []A, int z, int nz) {
		int temp=A[z];
		A[z]=A[nz];
		A[nz]=temp;
	}

	public static void pushPositives(int []A) {
		int n=0;
		int p=0;
		while(p<A.length) {
			if(A[p]<0) {
				// NOTE: this pushes NEGATIVES to the front, not positives (see note above)
				swap(A, p, n);
				n++;
			}
			p++;
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
		pushPositives(A);
		for (int i : A) {
			System.out.println(i+" ");
		}
	}

}