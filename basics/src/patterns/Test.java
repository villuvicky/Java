package patterns;

public class Test {

	public static void main(String[] args) {
		int n = 4;
		int num = 1; // NOTE: declared once here, but every block below
					 // reassigns "num" explicitly before using it
					 // (num = i-1, num = i, etc.), so — unlike the
					 // shared "count"/"ch" variables seen in earlier
					 // files — there is no accidental leakage of values
					 // between rows or between blocks here.

		/*
		 * Q1: Print a left-aligned shrinking triangle for a given N number
		 * of rows, where row r has (N - r + 1) numbers, counting DOWN from
		 * (N - r + 1) to 1.
		 *
		 * NOTE: The outer loop is written unusually — it counts from
		 * (n+1) down to 2 (i.e. "i > 1") instead of a more natural
		 * "i = n; i >= 1; i--". Both approaches produce the same 4 rows
		 * here; this version simply computes the starting number as
		 * "num = i - 1" to compensate for starting the loop one step
		 * higher than N.
		 *
		 * Pattern for N = 4
		 * 4321
		 * 321
		 * 21
		 * 1
		 */
		for (int i = n + 1; i > 1; i--) {
			num = i - 1; // starting value for this row
			for (int j = 1; j < i; j++) {
				System.out.print(num);
				num--;
			}
			System.out.println();
		}

		System.out.println("********** Q1 **********");


		/*
		 * Q2: Print a left-aligned growing triangle for a given N number of
		 * rows (starting from row length 2, not 1), where row i has i
		 * numbers counting DOWN from i to 1.
		 *
		 * IMPORTANT NOTE: Together, Q1 and Q2 form a symmetric
		 * "shrink-then-grow" shape very similar in spirit to HourGlass.java
		 * — Q1 shrinks from "4321" down to "1", and Q2 grows back up from
		 * "21" to "4321". The single-digit row "1" only appears once
		 * (at the end of Q1) because Q2's outer loop deliberately starts
		 * at i=2, not i=1 — otherwise "1" would be printed twice in a row,
		 * the same off-by-one pitfall discussed for HourGlass.java.
		 *
		 * Pattern for N = 4
		 * 21
		 * 321
		 * 4321
		 */
		for (int i = 2; i <= n; i++) {
			num = i;
			for (int j = 1; j <= i; j++) {
				System.out.print(num);
				num--;
			}
			System.out.println();
		}

		System.out.println("********** Q2 **********");


		/*
		 * Q3: Print a left-aligned triangle of letters for a given N number
		 * of rows, where row i prints i letters starting from 'A'.
		 *
		 * NOTE: "ch" is declared and reset to 'A' INSIDE the outer loop
		 * (once per row), which is why every row restarts from 'A' instead
		 * of continuing the alphabet across rows. Compare this with
		 * CharacterPattern.java Q4, where "ch" was declared OUTSIDE the
		 * loop and therefore kept advancing continuously — the placement
		 * of a variable's declaration (inside vs. outside the loop) is
		 * exactly what decides "resets every row" vs. "continues forever".
		 *
		 * ALSO NOTE: the commented-out line "//ch=(char) (ch+1);" is dead
		 * code — it's just an alternate (equivalent) way of writing
		 * "ch++", left in as a leftover/reminder and never executed.
		 *
		 * Pattern for N = 4
		 * A
		 * AB
		 * ABC
		 * ABCD
		 */
		for (int i = 1; i <= n; i++) {
			char ch = 'A'; // resets every row -> triangle restarts from 'A' each time
			for (int j = 1; j <= i; j++) {

				System.out.print(ch);
				// ch=(char) (ch+1); // dead code, equivalent to ch++ below
				ch++;
			}
			System.out.println();
		}

		System.out.println("********** Q3 **********");


		/*
		 * Q4: Print an N x N grid for a given N, where each row prints
		 * numbers from N down to 1, EXCEPT the position matching the
		 * current row number (i), which is replaced with a "*" — so the
		 * star's position slides diagonally from right to left as the
		 * row number increases.
		 *
		 * NOTE: The inner loop counts DOWN (j = n; j >= 1; j--), so the
		 * numbers themselves are always printed in descending order
		 * (N, N-1, ..., 1) regardless of row; only the position of the
		 * "*" changes per row (whenever j == i). This "replace one
		 * position based on a condition" technique is a common building
		 * block for diagonal or spiral-style patterns.
		 *
		 * Pattern for N = 4
		 * 432*
		 * 43*1
		 * 4*21
		 * *321
		 */
		for (int i = 1; i <= n; i++) {
			for (int j = n; j >= 1; j--) {
				// Print '*' at the sliding position
				if (j == i) {
					System.out.print("*");
				} else {
					System.out.print(j);
				}
			}
			System.out.println();
		}

		System.out.println("********** Q4 **********");
	}

}