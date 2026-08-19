package arrays;

import java.util.Scanner;

/*
 * Q1: Given an array of integers (read from input), find and return the
 * second-largest DISTINCT value in the array (i.e. duplicates of the
 * largest value should not count as the "second largest").
 *
 * Approach: track both the largest and second-largest values seen so
 * far in a single pass. Whenever a new overall maximum is found, the
 * old maximum "demotes" to become the new second-largest. Otherwise, if
 * a value is bigger than the current second-largest AND isn't equal to
 * the current largest, it becomes the new second-largest.
 *
 * NOTE ON THE "i != large" CHECK: this condition is what correctly
 * ignores DUPLICATES of the largest value when updating secondLarge.
 * Without it, an array like {5, 5, 3} would incorrectly report 5 as
 * the second-largest (since the second 5 would satisfy "5 > secondLarge"),
 * when really there's no valid distinct second-largest below 5 other
 * than 3.
 *
 * NOTE ON RETURN VALUE FOR EDGE CASES: if the array has no distinct
 * second-largest value (e.g. all elements are equal, like {5, 5, 5}, or
 * the array has only 1 element), this returns Integer.MIN_VALUE. That's
 * a reasonable sentinel, but it's worth explicitly checking for it at
 * the call site if you need to report "no second largest exists" as a
 * distinct case rather than treating MIN_VALUE as a normal number.
 *
 * NOTE ON LEFTOVER DEBUG PRINTS: the two
 * "System.out.println(large)/println(secondLarge)" lines right after
 * initialization just print Integer.MIN_VALUE twice before any real
 * processing happens — these look like leftover debugging statements
 * and can be safely removed for cleaner output.
 *
 * Trace for arr = {1, 3, 2}:
 *   i=1: 1 > large(MIN) -> secondLarge=MIN, large=1
 *   i=3: 3 > large(1)   -> secondLarge=1,   large=3
 *   i=2: 2 > large(3)? no. 2 > secondLarge(1) && 2 != large(3)? yes -> secondLarge=2
 *   final secondLarge = 2
 *
 * Output: 2
 */
public class SecondLargestNumber {
	
	public static int secondLargest_element(int arr[],int n) {
		
		int large=Integer.MIN_VALUE;
		int secondLarge=Integer.MIN_VALUE;
		System.out.println(large); // NOTE: leftover debug print (see note above)
		System.out.println(secondLarge); // NOTE: leftover debug print (see note above)
		 for (int i : arr) {
			  
			 if(i>large) {
				 secondLarge=large; // old max demotes to second-largest
				 large=i;
			 }
			 else if(i>secondLarge&&i!=large) {
				 // i!=large ensures duplicates of the max don't count as second-largest
				 secondLarge = i;
			 }
			
		}
		return secondLarge;
	}
	

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();

		int arr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(secondLargest_element(arr,n));
	}

}