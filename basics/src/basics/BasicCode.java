package basics;

public class BasicCode {

	/*
	 * Q1: Demonstrate basic Java fundamentals in a single program:
	 * (a) how primitive variable assignment works ("a = b" vs re-assigning
	 *     "a" afterwards), (b) printing a simple string, and (c) creating
	 *     and inspecting the length of a 2D array.
	 *
	 * IMPORTANT CORRECTION NOTE: The original comments in this file say
	 * "a is stored in stack memory, object is stored in heap" and "10 is
	 * moved to garbage collection" — this is NOT accurate for primitives.
	 * `int` is a PRIMITIVE type, not an object: the value 10 is stored
	 * directly inside the variable's slot on the stack, with no separate
	 * heap allocation and no boxing/object involved. There is nothing for
	 * the garbage collector to clean up here. Heap allocation, references,
	 * and garbage collection only come into play for reference types
	 * (objects, arrays, Strings, wrapper classes like Integer, etc.) —
	 * NOT for primitives like int, char, boolean, double, etc.
	 * What actually happens step by step:
	 *   int a = 10;   -> a directly holds the value 10 on the stack
	 *   int b = a;    -> b gets its OWN independent COPY of the value 10
	 *                    (not a reference to the same "10")
	 *   a = 5;        -> only a changes to 5; b still holds 10, completely
	 *                    unaffected, because they were never linked
	 *
	 * Output:
	 * Hello World!
	 * 5
	 */
	public static void main( String[] args )// main method which has static , so it will run at initially without creating an object
	{

	int a=10;
	// a is a primitive int holding the value 10 directly (see note above)

	int b=a;
	// b receives an independent copy of a's current value (10), not a
	// reference/pointer to it

	a=5;
	// only a changes here; b is unaffected since primitives are copied by value

	System.out.println( "Hello World!" );

	/*
	 * Creates a 2D array with 2 rows and 5 columns (jagged-array style
	 * declaration: an array of 2 int-array references, each initialized
	 * to length 5). arr[0].length gives the number of COLUMNS in row 0,
	 * not the total number of elements in the whole 2D array.
	 */
	int [][] arr = new int[2][5];
	System.out.println(arr[0].length); // prints 5

	}

}