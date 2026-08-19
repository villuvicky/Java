package basics;

/*
 * Q1: Given a number N, check whether it is a palindrome (reads the
 * same forwards and backwards, e.g. 121, 1331) by reversing its digits
 * and comparing the reversed number to the original.
 *
 * Approach: Repeatedly pull off the last digit using (n % 10), build up
 * a reversed number using (reversedNumber * 10 + remainder), and strip
 * the last digit off n using (n / 10), until n becomes 0.
 *
 * NOTE ON EDGE CASES:
 * - Negative numbers: the loop condition is "n > 0", so if n is
 *   negative, the loop never runs and reversedNumber stays 0. This
 *   means negative numbers will always be reported as "not a
 *   palindrome" (0 != n) regardless of their digits, since the sign
 *   isn't handled separately.
 * - Numbers ending in 0 (e.g. 120): reversing drops the leading zero
 *   that would result (120 reversed digit-by-digit would conceptually
 *   be "021", but leading zeros aren't preserved in an int, so it comes
 *   out as 21). This is actually fine here, since 120 genuinely isn't a
 *   palindrome — but it's a subtlety worth knowing if you ever needed
 *   to reverse a number while preserving trailing/leading zero digits.
 *
 * Example:
 * Input:  n = 1
 * Output: true   (single-digit numbers are always palindromes)
 */
public class PalindromeNumber {


	public static int palindrome(int n) {

		int reversedNumber=0;

		while(n>0) {

			int remainder=n%10; // pulls off the last digit
			reversedNumber=reversedNumber*10+remainder; // builds the reversed number
			n=n/10; // removes the last digit from n
		} 

		return reversedNumber;
	}

	public static void main(String[] args) {
		int n=010;
		if(palindrome(n)==n)
			System.out.println(true);
		else
			System.out.println(false);
	}

}