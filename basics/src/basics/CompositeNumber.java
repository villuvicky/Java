package basics;

/*
 * Q1: Given a number N, print all composite numbers between 2 and N
 * (inclusive). A composite number is a positive integer greater than 1
 * that has more than 2 factors (i.e. it is NOT prime and NOT 1).
 *
 * Approach: For each candidate i from 2 to N, count how many numbers
 * from 2 to i divide i evenly, starting the count at 1 (to account for
 * the implicit factor of 1, which is never explicitly checked). If i
 * ends up with more than 2 total factors, it's composite.
 *
 * NOTE ON WHY count STARTS AT 1: the inner loop only checks divisors
 * from j=2 to j=i, so it never explicitly tests whether 1 divides i
 * (every number is divisible by 1). Starting count at 1 accounts for
 * that missing factor without needing an extra check. Since the inner
 * loop always includes j=i itself (i % i == 0 is always true), every
 * number gets counted at least twice (the implicit 1, and itself) —
 * primes stop there with count == 2, while composites pick up at least
 * one more divisor in between, pushing count above 2.
 *
 * IMPORTANT NOTE ON EFFICIENCY: This is a brute-force O(N^2) approach
 * (checking every possible divisor from 2 to i, for every i up to N).
 * A more efficient version would only need to check divisors up to
 * sqrt(i) — see PrimeNumbers.java in this same set of files, which uses
 * exactly that optimization (checking divisibility only "i * i <= n")
 * to determine primality far more efficiently. Since "composite" is
 * just "not prime and not 1", you could reuse that same isPrime() logic
 * here instead of the current brute-force nested loop.
 *
 * Example:
 * Input:  n = 15
 * Output:
 * 4
 * 6
 * 8
 * 9
 * 10
 * 12
 * 14
 * 15
 */
public class CompositeNumber {
	
	public  static void composite(int n) {
		
		for (int i=2;i<=n;i++) {
			int count=1; // accounts for the implicit factor of 1 (see note above)
			for(int j=2;j<=i;j++) {
				if(i%j==0)
					count++;
			}
			
			if(count>2) {
				System.out.println(i); // more than 2 factors -> composite
			}
		}
		
	}

	public static void main(String[] args) {
	
		int n=15;
		composite(n);

	}

}