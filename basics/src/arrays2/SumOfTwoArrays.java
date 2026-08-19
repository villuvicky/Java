package arrays2;

/*
 * Q1: Given two arrays of digits, each representing a large number
 * (most significant digit first, e.g. {6,9,8} represents 698), compute
 * their sum digit-by-digit and return the result as a digit array —
 * the same way you'd add two numbers by hand, right to left, carrying
 * over into the next column when a column's sum reaches 10 or more.
 *
 * Approach: walk both arrays from the LAST digit (least significant)
 * toward the first, adding corresponding digits plus any carry from
 * the previous column, writing (sum % 10) into the output and carrying
 * (sum / 10) forward. Once one array runs out of digits, continue
 * processing the remaining digits of whichever array is longer (still
 * folding in the carry). Finally, if there's a leftover carry after
 * everything else, it becomes an extra leading digit in the output.
 *
 * IMPORTANT NOTE ON WHY "if (i > j)" CORRECTLY IDENTIFIES THE LONGER
 * ARRAY: at the start, i = arr1.length-1 and j = arr2.length-1. Inside
 * the main while loop, i and j always decrease together, IN LOCKSTEP,
 * one step per iteration — so the GAP between i and j never changes
 * from its initial value. That means whichever index is still larger
 * once the loop ends is exactly the array that started longer (and
 * therefore still has leftover digits to process). This is a subtle
 * but important reason the check works — it's not comparing "remaining
 * digit counts" directly, it's relying on the fact that the two indices
 * drift apart by a FIXED, unchanging amount.
 *
 * NOTE ON LEFTOVER DEBUG PRINTS: the two
 * "System.out.println("i is "+i)" / "System.out.println("j is "+j)"
 * lines inside the main loop are leftover debug statements not needed
 * for the actual computation — safe to remove for cleaner output.
 *
 * NOTE ON OUTPUT ARRAY SIZING: main() allocates the output array with
 * one MORE slot than the longer input array (to leave room for a
 * possible extra leading digit from a final carry, e.g. 99 + 1 = 100).
 * If that extra carry never materializes, the output's leading digit
 * simply stays 0 (Java arrays default to 0) — which is fine
 * numerically, but would print as a leading zero if displayed directly
 * as a number rather than digit-by-digit.
 *
 * Trace for arr1 = {6,9,8} (698), arr2 = {5,9,2} (592), output length = 4:
 *   i=2,j=2,k=3: sum=0+8+2=10 -> output[3]=0, carry=1
 *   i=1,j=1,k=2: sum=1+9+9=19 -> output[2]=9, carry=1
 *   i=0,j=0,k=1: sum=1+6+5=12 -> output[1]=2, carry=1
 *   i=-1,j=-1 -> main loop ends; i>j is false (equal, both -1) -> "else" branch runs but j<0 so nothing happens
 *   carry(1) > 0 -> output[0] = 1
 *
 * Output: 1 2 9 0   (representing 1290, since 698 + 592 = 1290)
 */
public class SumOfTwoArrays {


	public static void sum(int arr1[], int arr2[], int output[]) {

		int i=arr1.length-1;
		int j=arr2.length-1;
		int k=output.length-1;

		int carry=0;

		while(i>=0&&j>=0) {

			int sum=carry+arr1[i]+arr2[j];
			output[k]=sum%10;
			carry=sum/10;
			System.out.println("i is "+i); // NOTE: leftover debug print (see note above)
			System.out.println("j is "+j); // NOTE: leftover debug print (see note above)
			i--;
			j--;
			k--;

		}
		if(i>j) {
			// arr1 was the longer array -> process its remaining digits
			//i=i+1;
			while(i>=0) {
				int sum=carry+arr1[i];
				output[k]=sum%10;
				carry=sum/10;
				i--;
				k--;
			}
		}
		else {
			// arr2 was the longer array (or they were equal length) -> process its remaining digits
			//j=j+1;
			while(j>=0) {
				int sum=carry+arr2[j];
				output[k]=sum%10;
				carry=sum/10;
				j--;
				k--;
			}
		}
		if (carry > 0) {
	        output[k] = carry; // final leftover carry becomes a new leading digit
	    }

	}

	public static void main(String[] args) {

		int [] arr1= {6,9,8};
		int [] arr2= {5,9,2};

		int k=0;
		if(arr1.length>arr2.length) {
			k=arr1.length+1;
		}
		else
		{
			k=arr2.length+1;	
		}
		int [] output= new int[k];

		sum(arr1, arr2, output);
		for (int ii : output) {
			System.out.print(ii+" ");
		}
	}

}