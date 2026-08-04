package patterns;

public class Fibonacci {

	/*
	 * Q1: Write a recursive method that returns the N-th term of a
	 * Fibonacci-style sequence, where the first two terms are both 1,
	 * and every term after that is the sum of the two preceding terms.
	 *
	 * fibonacci(0) = 1
	 * fibonacci(1) = 1
	 * fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)   for n >= 2
	 *
	 * NOTE ON INDEXING: This is NOT the textbook Fibonacci sequence
	 * (which usually starts 0, 1, 1, 2, 3, 5...). Here BOTH base cases
	 * return 1, so the sequence generated is: 1, 1, 2, 3, 5, 8, 13, ...
	 * — effectively the standard Fibonacci sequence shifted by one
	 * position (this method's fibonacci(n) equals the standard
	 * fibonacci(n+1)). Always double-check which indexing convention a
	 * problem expects before assuming n=0 gives 0.
	 *
	 * IMPORTANT NOTE ON EFFICIENCY: This implementation recalculates the
	 * same subproblems many times (e.g. fibonacci(3) gets computed
	 * separately inside both fibonacci(4) and fibonacci(5)'s call trees).
	 * This gives it exponential time complexity, O(2^n), because each
	 * call branches into two more calls with no caching of results. For
	 * larger n (roughly n > 35-40), this becomes noticeably slow. A
	 * common interview follow-up is to optimize this using memoization
	 * (caching computed values in an array/map) or converting it to an
	 * iterative bottom-up approach, both of which bring it down to O(n).
	 *
	 * Trace for fibonacci(5):
	 * fibonacci(0) = 1
	 * fibonacci(1) = 1
	 * fibonacci(2) = fibonacci(1) + fibonacci(0) = 1 + 1 = 2
	 * fibonacci(3) = fibonacci(2) + fibonacci(1) = 2 + 1 = 3
	 * fibonacci(4) = fibonacci(3) + fibonacci(2) = 3 + 2 = 5
	 * fibonacci(5) = fibonacci(4) + fibonacci(3) = 5 + 3 = 8
	 *
	 * Output: 8
	 */
	static int fibonacci(int n) {
		// base case
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;

		// recursive case: sum of the two previous terms
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {

		System.out.println(fibonacci(5));

	}

}