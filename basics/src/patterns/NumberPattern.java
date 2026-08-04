package patterns;

public class NumberPattern {

	public static void main(String[] args) {

		int n = 4;

		/*
		 * Q1: Print the following pattern for a given N number of rows,
		 * where each row contains the row number repeated N times.
		 *
		 * Pattern for N = 4
		 * 1111
		 * 2222
		 * 3333
		 * 4444
		 */
		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n; j++) {
				System.out.print(i); // print row number, not column number
			}
			System.out.println(); // move to next line after each row
		}

		System.out.println("********** Q1 **********");


		/*
		 * Q2: Print the following pattern for a given N number of rows,
		 * where each row prints 1 to N (same sequence repeated every row).
		 *
		 * Pattern for N = 4
		 * 1234
		 * 1234
		 * 1234
		 * 1234
		 */
		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n; j++) {
				System.out.print(j); // print column number, same for every row
			}
			System.out.println();
		}

		System.out.println("********** Q2 **********");


		/*
		 * Q3: Print the following pattern for the given N number of rows.
		 *
		 * Pattern for N = 3
		 * 321
		 * 321
		 * 321
		 */
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				// n - j counts backward from n to 1 as j goes 0 to n-1
				System.out.print(n - j);
			}
			System.out.println();
		}

		System.out.println("********** Q3 **********");


		/*
		 * Q4: Print the following pattern for the given N number of rows.
		 *
		 * Pattern for N = 3
		 * 1
		 * 22
		 * 333
		 */
		for (int i = 1; i <= n; i++) {

			// j only goes up to i, so row i has exactly i characters
			for (int j = 1; j <= i; j++) {
				System.out.print(i);
			}
			System.out.println();
		}

		System.out.println("********** Q4 **********");


		/*
		 * Q5: Print the following pattern for a given N number of rows,
		 * where the first row is filled with N, the next with N-1,
		 * and so on down to 1 on the last row.
		 *
		 * Pattern for N = 4
		 * 4444
		 * 3333
		 * 2222
		 * 1111
		 */
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				// n - i decreases by 1 each new row (row 0 -> n, row 1 -> n-1, ...)
				System.out.print(n - i);
			}
			System.out.println();
		}

		System.out.println("********** Q5 **********");


		/*
		 * Q6: Print an N x N grid where row i starts counting from i
		 * and wraps back to 1 after reaching N.
		 *
		 * Pattern for N = 4
		 * 1 2 3 4
		 * 2 3 4 1
		 * 3 4 1 2
		 * 4 1 2 3
		 */
		for (int i = 1; i <= n; i++) {
			int num = i; // each row starts its count from the row number

			for (int j = 1; j <= n; j++) {
				System.out.print(num + " ");
				num++;
				// wrap around back to 1 once num exceeds n
				if (num > n) {
					num = 1;
				}
			}
			System.out.println();
		}

		System.out.println("********** Q6 **********");


		/*
		 * Q7: Print numbers from 1 to N in a single line.
		 *
		 * Output for N = 4
		 * 1234
		 */
		for (int i = 1; i <= n; i++) {
			System.out.print(i);
		}
		System.out.println();

		System.out.println("********** Q7 **********");


		/*
		 * Q8: Print (N-2) rows where each row has 1 at the start,
		 * followed by (N-2) spaces, and 2 at the end - forming the
		 * side borders of a box marked with 1 and 2.
		 *
		 * Output for N = 4 (n-2 = 2 rows)
		 * 1  2
		 * 1  2
		 */
		for (int i = 1; i <= n - 2; i++) {
			System.out.print(1); // left border marker

			// print n-2 spaces to create the gap between borders
			for (int j = 1; j <= n - 2; j++) {
				System.out.print(" ");
			}
			System.out.print(2); // right border marker
			System.out.println();
		}

		System.out.println("********** Q8 **********");


		/*
		 * Q9: If N is greater than 1, print numbers 1 to N in a single line;
		 * otherwise print nothing.
		 *
		 * Output for N = 4
		 * 1234
		 */
		if (n > 1) {
			for (int i = 1; i <= n; i++) {
				System.out.print(i);
			}

		}
		System.out.println();

		System.out.println("********** Q9 **********");


		/*
		 * Q10: Print an N x N grid filled with continuously increasing
		 * numbers starting from 1, moving left to right, top to bottom.
		 *
		 * Output for N = 4
		 * 1 2 3 4
		 * 5 6 7 8
		 * 9 10 11 12
		 * 13 14 15 16
		 */
		int num = 1; // tracks the next number to print, shared across all rows
		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n; j++) {
				System.out.print(num + " ");
				num = num + 1; // increment continues across rows (not reset per row)
			}
			System.out.println();
		}

		System.out.println("********** Q10 **********");


		/*
		 * Q11: Print a left-aligned triangle for a given N number of rows,
		 * where row i prints numbers from 1 to i.
		 *
		 * Pattern for N = 4
		 * 1
		 * 12
		 * 123
		 * 1234
		 */
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}

		System.out.println("********** Q11 **********");


		/*
		 * Q12: Print a left-aligned triangle for a given N number of rows,
		 * where each value in row i is calculated as (i + j - 1),
		 * so row i starts from i and increases by 1 across the row.
		 *
		 * Pattern for N = 4
		 * 1
		 * 23
		 * 345
		 * 4567
		 */
		int count = 0; // NOTE: declared here but NOT used in this loop —
		// it is reused later in Q13 and Q14 below.
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + j - 1);
			}
			System.out.println();
		}

		System.out.println("********** Q12 **********");


		/*
		 * Q13: Print a left-aligned triangle for a given N number of rows,
		 * where the printed numbers increase continuously (1, 2, 3, ...)
		 * across the ENTIRE pattern, not resetting for each row.
		 *
		 * IMPORTANT NOTE: "count" is declared OUTSIDE the loop (see Q12),
		 * so its value persists across rows. This is what makes numbering
		 * continuous instead of restarting at 1 on every row.
		 *
		 * Pattern for N = 4
		 * 1
		 * 23
		 * 456
		 * 78910
		 */
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(count = count + 1);
			}
			System.out.println();
		}

		System.out.println("********** Q13 **********");


		/*
		 * Q14: Print a right-aligned triangle for a given N number of rows,
		 * padded with (N-i) leading spaces, where the numbers continue
		 * increasing from wherever Q13 left off.
		 *
		 * IMPORTANT NOTE: This loop reuses the SAME "count" variable from
		 * Q13 without resetting it to 0. So if Q13 ended at 10, this pattern
		 * continues from 11 onward. If you want this pattern to be
		 * independent and start fresh at 1, add "count = 0;" right before
		 * this loop.
		 *
		 * Pattern for N = 4 (continuing count from Q13, which ended at 10)
		 *    11
		 *   12 13
		 *  14 15 16
		 * 17 18 19 20
		 */
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= i; j++) {
				System.out.print(count = count + 1);
				System.out.print(" ");
			}
			System.out.println();
		}

		System.out.println("********** Q14 **********");


		/*
		 * Q15: Print a left-aligned triangle for a given N number of rows,
		 * where row i prints numbers counting DOWN from N to (N-i+1),
		 * each followed by a space.
		 *
		 * Pattern for N = 4
		 * 4
		 * 4 3
		 * 4 3 2
		 * 4 3 2 1
		 */
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(n - j + 1 + " ");
			}
			System.out.println();
		}

		System.out.println("********** Q15 **********");


		/*
		 * Q16: Print an inverted left-aligned triangle for a given N number
		 * of rows, where row i repeats the value (N-i+1) exactly (N-i+1)
		 * times (same value used both as the count AND the printed digit).
		 *
		 * Pattern for N = 4
		 * 4444
		 * 333
		 * 22
		 * 1
		 */
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i + 1; j++) {
				System.out.print(n - i + 1);
			}
			System.out.println();
		}

		System.out.println("********** Q16 **********");


		/*
		 * Q17: Print a right-aligned "hill" number pattern for a given N
		 * number of rows, where row i rises from i up to (2*i - 1) and then
		 * falls back down — each row's peak is higher than the last.
		 *
		 * IMPORTANT NOTE: after the ascending loop ends, "num" has already
		 * been incremented one step past the peak, so "num = num - 2"
		 * rewinds it by 2 (one step back to the peak, then one more step
		 * to start the descending sequence) before the descending loop
		 * begins.
		 *
		 * Pattern for N = 4
		 *    1
		 *   232
		 *  34543
		 * 4567654
		 */
		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}

			num = i; // ascending part starts from the row number
			for (int j = 1; j <= i; j++) {
				System.out.print(num);
				num++;
			}

			num = num - 2; // rewind to start the descending part correctly
			for (int j = 1; j < i; j++) {
				System.out.print(num);
				num--;
			}

			System.out.println();
		}

		System.out.println("********** Q17 **********");


		/*
		 * Q18: Print a right-aligned "1234...4321" style diamond pattern for
		 * a given N number of rows, where row i counts up from 1 to i, then
		 * back down to 1 (a numeric palindrome each row).
		 *
		 * Pattern for N = 4
		 *    1
		 *   121
		 *  12321
		 * 1234321
		 */
		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}

			// ascending part: 1 up to i
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}

			// descending part: (i-1) down to 1
			num = i - 1;
			for (int j = 1; j < i; j++) {
				System.out.print(num);
				num--;
			}
			System.out.println();
		}

		System.out.println("********** Q18 **********");
	}
}