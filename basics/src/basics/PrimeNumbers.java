package basics;

import java.util.Scanner;

/*
 * Q1: Given a range [start, end] (read from input), print all prime
 * numbers within that range.
 *
 * Approach for isPrime(): handle the small special cases first (numbers
 * <= 1 are never prime; 2 is prime; any other even number is not prime),
 * then only test ODD divisors from 3 up to sqrt(n) for the remaining
 * candidates.
 *
 * NOTE ON EFFICIENCY (good technique worth remembering): This is
 * significantly more efficient than a naive "check every divisor from 2
 * to n" approach:
 *   - Checking divisibility only up to sqrt(n) (via "i * i <= n") is
 *     sufficient because if n has a factor larger than sqrt(n), it must
 *     also have a corresponding factor smaller than sqrt(n) — so no
 *     factor pair can be missed by stopping there.
 *   - Skipping even numbers entirely after handling 2 as a special case
 *     (starting the loop at i=3 and incrementing by 2) cuts the number
 *     of checks roughly in half, since no even number greater than 2
 *     can ever be prime.
 * Compare this with CompositeNumber.java in this same set of files,
 * which uses a much less efficient O(n^2) brute-force approach that
 * checks every divisor from 2 to i for every candidate — the isPrime()
 * logic here could be reused there instead (a composite number is
 * simply any number > 1 that is NOT prime).
 *
 * Example:
 * Input:  start = 10, end = 20
 * Output: 11 13 17 19
 */
public class PrimeNumbers {

    // Method to check if a number is prime
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        // Check divisibility only up to sqrt(n), skipping even divisors
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
}