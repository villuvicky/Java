package arrays2;

import java.util.Scanner;

/*
 * Q1: Given an array with some spare capacity (its allocated length is
 * larger than its current number of used elements), insert a new value
 * at a given position, shifting all elements from that position onward
 * one slot to the right to make room.
 *
 * Approach: starting from the last used slot (index = size) and moving
 * backward down to (but not including) "position", copy each element
 * one slot to the right (A[i] = A[i-1]). This opens up a gap at
 * "position", which is then filled with newValue.
 *
 * IMPORTANT NOTE — "size++" DOES NOTHING FOR THE CALLER: "size" is a
 * primitive int parameter, so it's passed BY VALUE. Incrementing it
 * inside insert() only changes insert()'s own local copy — it has NO
 * effect on the "size" variable back in main(). If main() needs to
 * know the array's new logical size after inserting, insert() would
 * need to either RETURN the new size (e.g. "return size + 1;") or the
 * caller would need to increment its own "size" variable itself after
 * calling insert(). As written, main()'s "size" stays exactly as it
 * was before the call.
 *
 * IMPORTANT NOTE — PRECONDITION ON CAPACITY: this shifts elements up to
 * and including index "size" (A[size] = A[size-1]), which means the
 * array MUST have at least one more slot than the current number of
 * used elements (capacity > size) for this to work. If capacity == size
 * (the array is already full), this throws an
 * ArrayIndexOutOfBoundsException at A[size], since that index doesn't
 * exist. Always ensure there's spare capacity before calling insert().
 *
 * NOTE: no bounds checking is done on "position" itself either — a
 * position outside the valid range (e.g. negative, or beyond the
 * current size) would also throw an exception rather than being
 * rejected gracefully with an error message.
 *
 * Example:
 * Input: capacity = 6, size = 5, A = [1, 2, 3, 4, 5], position = 2, newValue = 99
 * Output: [1, 2, 99, 3, 4, 5]  (5 shifted into 5's old slot,
 *                               everything from position 2 onward shifted right)
 */
public class Insertion {

	public static int takeInput(String str) {

		System.out.println(str);
		Scanner sc= new Scanner(System.in);
		return sc.nextInt();
	}
	public static void insert(int []A, int position ,int newValue,int size) {
		
		// shift everything from "size" down to "position" one slot right
		for(int i=size;i>position;i--) {
			A[i]=A[i-1];
		}
		
		A[position]=newValue;
		size++; // NOTE: has no effect on the caller's "size" (see note above)

	}
	public static void main(String[] args) {

		int capacity=takeInput("Enter capacity");
		int size=takeInput("Enter size");

		int A[]=new int[capacity];

		for (int i=0; i<size;i++) {
			A[i]=takeInput("Enter value");
		}

		int position=takeInput("Enter position");
		int newValue=takeInput("Enter new value");
		insert(A, position, newValue,size);
		for (int i : A) {
			System.out.println(i+" ");
		}

	}

}