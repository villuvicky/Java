package arrays2;

/*
 * Q1: Given a number N, arrange the numbers 1 to N into an array such
 * that all ODD numbers appear first in ASCENDING order, followed by all
 * EVEN numbers in DESCENDING order.
 *
 * Approach: fill the first half of the array with 1, 3, 5, 7, ...
 * (odd numbers, ascending), then fill the rest with the largest even
 * number down to 2 (even numbers, descending).
 *
 * NOTE ON THE TERNARY FOR THE SECOND LOOP'S STARTING POINT:
 * "(n % 2 == 0 ? n : n - 1)" picks the largest EVEN number that is
 * <= n, regardless of whether n itself is odd or even. This handles
 * both cases with one line instead of writing separate logic for
 * odd-N and even-N — a clean way to avoid an if/else branch here.
 *
 * NOTE: the "n" parameter is passed in separately from "arrange.length",
 * even though they're always equal in main() — arrange.length could
 * have been used directly inside the method instead, but passing n
 * explicitly does make the method's size-dependence more visible at a
 * glance.
 *
 * Trace for N = 10:
 *   odd numbers ascending:  1, 3, 5, 7, 9        (fills indices 0-4)
 *   even numbers descending: 10, 8, 6, 4, 2       (fills indices 5-9)
 *
 * Output: 1 3 5 7 9 10 8 6 4 2
 */
public class ArrangeNumbersInArray {
	

	public static void arrange(int [] arrange,int n) {
		
		
		int index=0;
		// fill with odd numbers 1, 3, 5, ... in ascending order
		for(int i=1;i<=n;i+=2) {
			arrange[index++]=i;
			
		}
		// fill with even numbers, descending, starting from the largest even <= n
		 for (int i = (n % 2 == 0 ? n : n - 1); i >= 2; i -= 2) {
			 arrange[index++] = i;
	        }
		
	}
	
	public static void main(String[] args) {
		int [] arrange= new int[10];
		int n=arrange.length;
		arrange(arrange, n);
		for (int i : arrange) {
			System.out.print(i+" ");
		}

	}

}