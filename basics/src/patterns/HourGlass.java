package patterns;

public class HourGlass {

	public static void main(String[] args) {

		int n = 7;

		/*
		 * Q1: Print the TOP half of a number hourglass for a given N,
		 * where row i is padded with (i-1) leading spaces and then prints
		 * numbers from i up to N (each row starts one number later and
		 * therefore has one fewer number than the row before it).
		 *
		 * Pattern for N = 7
		 * 1 2 3 4 5 6 7
		 *  2 3 4 5 6 7
		 *   3 4 5 6 7
		 *    4 5 6 7
		 *     5 6 7
		 *      6 7
		 *       7
		 */
		for (int i = 1; i <= n; i++) {

			// leading spaces increase with i, shrinking the row from the left
			for (int j = 1; j <= i - 1; j++) {
				System.out.print(" ");
			}
			// each row starts printing from i (not 1) up to n
			for (int j = i; j <= n; j++) {

				System.out.print(j + " ");
			}
			System.out.println();
		}

		System.out.println("********** Q1 **********");


		/*
		 * Q2: Print the BOTTOM half of the number hourglass for a given N,
		 * mirroring Q1 in reverse — row i still uses the exact same inner
		 * logic as Q1 (same spacing formula, same number range), but the
		 * outer loop now counts DOWN from (N-1) to 1, so the widest row
		 * comes last instead of first.
		 *
		 * IMPORTANT NOTE: the outer loop starts at "n - 1", not "n". If it
		 * started at n, the narrowest row ("7 " for N=7) would be printed
		 * a second time right after Q1's last row, creating a duplicate
		 * "pinch point" in the hourglass instead of a single, sharp one.
		 * Starting at n-1 ensures Q1 and Q2 together form a clean hourglass
		 * with exactly one narrow row in the middle.
		 *
		 * Pattern for N = 7
		 *       6 7
		 *      5 6 7
		 *     4 5 6 7
		 *    3 4 5 6 7
		 *   2 3 4 5 6 7
		 *  1 2 3 4 5 6 7
		 */
		for (int i = n - 1; i >= 1; i--) {

			for (int j = 1; j <= i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = i; j <= n; j++) {

				System.out.print(j + " ");
			}
			System.out.println();
		}

		System.out.println("********** Q2 **********");

		/*
		 * NOTE: Q1 and Q2 together form the complete hourglass shape:
		 * Q1 narrows from full width down to a single number (the pinch),
		 * and Q2 immediately widens back out from the next row after the
		 * pinch to full width again. Both loops reuse identical spacing
		 * and printing logic — only the direction (and starting point) of
		 * the outer loop differs.
		 */
	}

}