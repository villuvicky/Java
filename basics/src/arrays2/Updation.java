package arrays2;

import java.util.Scanner;

/*
 * Q1: Given an array, find the FIRST occurrence of a given "oldValue"
 * and replace it with "newValue". If oldValue doesn't exist anywhere in
 * the array, print "Key Not Found" instead.
 *
 * Approach: scan the array from the start; as soon as a matching value
 * is found, overwrite it and return immediately (stopping the scan
 * early via "return").
 *
 * NOTE: this only updates the FIRST matching occurrence, not every
 * occurrence. If oldValue appears multiple times in the array, all
 * later occurrences are left unchanged. If updating ALL occurrences
 * were the intended behavior instead, the "return" statement would
 * need to be removed (and the "Key Not Found" message would need a
 * "found" flag to only print if no match was EVER found across the
 * whole array).
 *
 * Example:
 * Input: A = [10, 20, 30, 20], oldValue = 20, newValue = 99
 * Output: [10, 99, 30, 20]   (only the FIRST 20 becomes 99)
 */
public class Updation {
	
	public static void update(int[] A, int oldValue, int newValue) {
		for(int i=0;i<A.length;i++) {
			
			if(A[i]==oldValue) {
				A[i]=newValue;
				return; // stops after updating the first match only (see note above)
			}
				
		}
		System.out.println("Key Not Found");
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

		int oldValue=takeInput("Enter old Value");
		int newValue=takeInput("Enter new value");
		update(A, oldValue, newValue);
		for (int i : A) {
			System.out.println(i+" ");
		}


	}

}