package arrays;

/*
 * Q1: Demonstrate the basics of working with arrays in Java: two
 * different ways to DECLARE an array variable, how to actually
 * ALLOCATE space for an array (with "new"), how to initialize an array
 * using array-literal syntax, and the two common ways to LOOP over an
 * array's elements (a classic indexed for-loop vs. a for-each loop).
 *
 * NOTE ON DECLARATION STYLES: "int arr[]" and "int[] arr2" are two
 * equally valid ways to declare an array variable in Java — they mean
 * exactly the same thing. The "int[] name" style (used for arr1 below)
 * is generally preferred/more common in modern Java code, since it
 * keeps the type ("int[]") together, rather than splitting the array
 * brackets away from the type name.
 *
 * NOTE: "arr2" is declared but never actually used (no array is ever
 * assigned to it) — this compiles fine, but is dead/unused code.
 *
 * NOTE ON THE TWO LOOP STYLES: the indexed for-loop
 * ("for (int i = 0; i < arr1.length; i++)") gives you access to the
 * INDEX (i) as well as the value (arr1[i]) — useful when you need to
 * know position, modify elements, or loop backwards/skip elements. The
 * for-each loop ("for (int i : arr1)") is more concise when you only
 * need each VALUE and don't care about its index or need to modify the
 * original array through the loop variable.
 *
 * Output (arr1 printed once with the indexed loop, then again with the
 * for-each loop, with two blank lines in between):
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 *
 *
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 */
public class Arrays {

	public static void main(String[] args) {
		
		int arr[]; // declaration style 1

		int [] arr2; // declaration style 2 (never assigned/used below)

		arr= new int[5]; // allocates an array of 5 ints (all default to 0)
		arr[0]=1;
		int[] arr1= {1,2,3,4,5,6}; // array-literal syntax: declares + initializes in one line

		// indexed loop: gives access to both index (i) and value (arr1[i])
		for(int i=0;i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
		System.out.println();
		System.out.println();

		// for-each loop: simpler when you only need the values, not the indices
		for (int i : arr1) {
		
			System.out.println(i);
		}

	}

}