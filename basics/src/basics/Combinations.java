package basics;

import java.util.Scanner;
import java.math.BigInteger;

/*
 * Q1: Given two integers N and R (read from input), compute the number of
 * combinations "N choose R" — the number of ways to pick R items from a
 * set of N items where order doesn't matter — using the formula:
 *
 *     nCr = n! / (r! * (n-r)!)
 *
 * Validate that R and N are non-negative and that R does not exceed N
 * before computing. Print n!, r!, and the final combination value.
 *
 * IMPORTANT NOTE: Factorials grow extremely fast (13! already exceeds
 * what a 32-bit int can hold). This implementation correctly uses
 * BigInteger instead of int/long for the factorial results, so it will
 * NOT overflow even for fairly large N — unlike Permutations.java (a
 * companion file), which uses a plain int for factorials and WILL
 * silently overflow for N >= 13. If you're comparing the two files, this
 * is the safer, more scalable approach.
 *
 * NOTE: The Scanner is never closed (no sc.close() at the end). This
 * isn't a correctness bug for a short-lived console program, but it's
 * good practice to close Scanner/System.in resources when you're done
 * with them, especially in larger or longer-running applications.
 *
 * Example:
 * Input:  n = 5, r = 2
 * Output:
 * 120        (5!)
 * 2          (2!)
 * 10         (5C2 = 120 / (2 * 6) = 10)
 */
public class Combinations {

    public static BigInteger facto(long v) {
        BigInteger fact = BigInteger.ONE;

        // multiply v * (v-1) * (v-2) * ... * 1
        for (long i = v; i > 0; i--) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long r = sc.nextLong();

        // Validation: r and n must be non-negative, and r cannot exceed n
        if (r < 0 || n < 0 || r > n) {
            System.out.println("Invalid input");
            return;
        }

        BigInteger factN = facto(n);
        System.out.println(factN);

        BigInteger factR = facto(r);
        System.out.println(factR);

        BigInteger factNR = facto(n - r);

        // nCr = n! / (r! * (n-r)!)
        BigInteger comb = factN.divide(factR.multiply(factNR));
        System.out.println(comb);
    }
}