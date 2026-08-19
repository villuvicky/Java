package arrays2;

import java.util.Arrays;

public class ArrayIntersection {

	/*
	 * Q1: Given two arrays, print their intersection (elements present
	 * in BOTH arrays, respecting duplicate counts) efficiently using
	 * sorting + a two-pointer merge, rather than brute-force checking.
	 *
	 * Approach: sort both arrays first, then walk through them with two
	 * pointers (i for a, j for b). Whenever the values match, print and
	 * advance both pointers. Whenever they don't match, advance whichever
	 * pointer points at the smaller value (since sorted order guarantees
	 * that value can't match anything later in the other array).
	 *
	 * IMPORTANT NOTE ON EFFICIENCY: sorting costs O(n log n + m log m),
	 * and the merge walk afterward is O(n + m) — overall much faster
	 * than the O(n * m) bruteForce() method below for large arrays.
	 *
	 * Trace for a = {1, 2, 2, 3, 4} (already sorted), b = {2, 2, 4, 6}
	 * (already sorted):
	 *   1 vs 2 -> 1 < 2, i++
	 *   2 vs 2 -> match, print 2, i++, j++
	 *   2 vs 2 -> match, print 2, i++, j++
	 *   3 vs 4 -> 3 < 4, i++
	 *   4 vs 4 -> match, print 4, i++, j++
	 *   i reaches a.length -> loop ends
	 *
	 * Output: 2 2 4
	 */
	public static void intersection(int[] a, int[] b) {
	    Arrays.sort(a);
	    Arrays.sort(b);

	    int i = 0, j = 0;

	    while (i < a.length && j < b.length) {
	        if (a[i] == b[j]) {
	            System.out.print(a[i] + " ");
	            i++;
	            j++;
	        } else if (a[i] < b[j]) {
	            i++;
	        } else {
	            j++;
	        }
	    }
	}

	/*
	 * Q2: Solve the same intersection problem using a brute-force
	 * approach, WITHOUT sorting — for each element of "a", scan "b" for
	 * a match that hasn't already been used.
	 *
	 * NOTE ON THE "visited" ARRAY: this uses a dedicated boolean array
	 * to mark which elements of "b" have already been matched, instead
	 * of overwriting matched values with a sentinel like
	 * Integer.MIN_VALUE (the technique used in the earlier
	 * IntersectionOfArrays.java file, in the "arrays" package). Both
	 * achieve the same goal — preventing the same "b" element from
	 * being matched twice — but this "visited" array approach is safer
	 * in general, since it doesn't rely on assuming a specific value
	 * (like MIN_VALUE) never legitimately appears in the input.
	 *
	 * IMPORTANT NOTE ON EFFICIENCY: this is O(n * m) since, for every
	 * element in "a", it may scan all of "b" — this is the slower
	 * baseline that intersection() above improves on.
	 */
	public static void bruteForce(int[] a, int[] b) {
	    boolean[] visited = new boolean[b.length];

	    for (int i = 0; i < a.length; i++) {
	        for (int j = 0; j < b.length; j++) {
	            if (a[i] == b[j] && !visited[j]) {
	                System.out.print(a[i] + " ");
	                visited[j] = true;
	                break;
	            }
	        }
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1, 2, 2, 3, 4};
			int []	 B = {2, 2, 4, 6};
			
		//	bruteForce(A, B);
			System.out.println();
			intersection(A, B);
	}

}