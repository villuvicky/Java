package patterns;

public class Test2 {

	public static void main(String[] args) {

		/*
		 * Q1: Given an integer N, extract its digits one at a time (from
		 * the last digit to the first) and classify each digit as odd or
		 * even. Print each digit along with its classification, and
		 * finally print the sum of all even digits and the sum of all
		 * odd digits found in N.
		 *
		 * Approach: Repeatedly use (n % 10) to get the last digit, check
		 * if it's odd or even, add it to the running "even" or "odd"
		 * total, then use (n / 10) to remove that digit and move to the
		 * next one. Stop when n becomes 0.
		 *
		 * NOTE: Because digits are extracted using n % 10, they come out
		 * in REVERSE order (last digit of N first, first digit last).
		 * The final sums are unaffected by order, but if you needed to
		 * print the digits back in their original left-to-right order,
		 * you'd need to either reverse the collected digits afterward or
		 * build the number back up using multiplication (e.g. result =
		 * result * 10 + reminder) instead of just printing directly.
		 *
		 * Input:  n = 552245
		 * Output (digits processed in order 5, 4, 2, 2, 5, 5):
		 * 5
		 * 5 is odd
		 * 4
		 * 4 is even
		 * 2
		 * 2 is even
		 * 2
		 * 2 is even
		 * 5
		 * 5 is odd
		 * 5
		 * 5 is odd
		 * 8 15
		 *
		 * (even total = 4 + 2 + 2 = 8, odd total = 5 + 5 + 5 = 15)
		 */
		int n = 552245;
		int odd = 0;
		int even = 0;

		while (n > 0) {

			int reminder = n % 10; // extracts the last digit of n
			System.out.println(reminder);

			if (reminder % 2 == 0) {
				System.out.println(reminder + " is even");
				even = even + reminder; // accumulate even digits
			} else {
				odd = odd + reminder; // accumulate odd digits
				System.out.println(reminder + " is odd");
			}
			n = n / 10; // strips off the last digit, shifting the rest right

		}

		System.out.println(even + " " + odd);

	}

}