package basics;


import java.util.Scanner;

/*
 * Q1: Given two integers N and R (read from input), compute the number
 * of permutations "N permute R" — the number of ways to arrange R items
 * chosen from a set of N items where ORDER matters — using the formula:
 *
 *     nPr = n! / (n-r)!
 *
 * Validate that R and N are non-negative and that R does not exceed N
 * before computing.
 *
 * IMPORTANT NOTE ON OVERFLOW: facto() uses a plain "int" to store the
 * factorial result. Since 13! (= 6,227,020,800) already exceeds the
 * maximum value an int can hold (2,147,483,647), this method will
 * silently produce WRONG (overflowed/wrapped-around) results for any
 * N >= 13 — with no error or warning. Compare this to Combinations.java
 * in this same set of files, which solves the same kind of factorial
 * problem using BigInteger instead, avoiding overflow entirely. If this
 * method needs to support larger N, switching facto()'s return type to
 * "long" would help a bit further (up to 20!), but BigInteger is the
 * only fully overflow-safe option for arbitrarily large N.
 *
 * NOTE ON checkValue()'s RETURN VALUE: it returns 1 for valid input and
 * -1 for invalid input, and main() stores that in a variable named
 * "diff" — a somewhat misleading name, since it's really a validity
 * flag/status code, not a numeric difference. Also, when input is
 * invalid, main() prints "diff" itself (i.e. -1) as the "error message",
 * rather than a descriptive string like "Invalid input" (as
 * Combinations.java does) — worth aligning the two for consistency.
 *
 * Example:
 * Input:  n = 5, r = 2
 * Output: 20   (5P2 = 5! / 3! = 120 / 6 = 20)
 */
public class Permutations {

	public static int permutation(int n, int r) {
		int factN = facto(n);
		int factNR = facto(n-r);
		int perm = factN/factNR;
		return perm;
	}

	public static int facto(int v) {
		int fact = 1;

		// WARNING: plain int here overflows for v >= 13 (see note above)
		for (int i = v; i > 0; i--) {
			fact = fact*i;
		}
		return fact;
	}

	public static int checkValue(int n, int r)
	{

		if (r < 0 || n < 0 || r > n) {
			return -1; // invalid input flag
		}

		else
			return 1; // valid input flag

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int r = sc.nextInt();
		int diff=checkValue(n, r); // validity flag, not a numeric difference (see note above)
		if(diff>0)
		{
			System.out.println(permutation(n, r));
		}
		else {

			System.out.println(diff);}
	}






}