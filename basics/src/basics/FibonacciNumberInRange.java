package basics;

/*
 * Q1: Given a number N, determine whether N is a Fibonacci number (i.e.
 * whether it appears in the sequence 0, 1, 1, 2, 3, 5, 8, 13, ...).
 *
 * Approach: Generate Fibonacci numbers one at a time starting from
 * a=0, b=1, and keep checking whether the newly generated number equals
 * N. Stop as soon as the generated number exceeds N (since the sequence
 * only increases from there, there's no point checking further).
 *
 * IMPORTANT NOTE ON THE n==0 SPECIAL CASE: The explicit
 * "if (n == 0) return true;" check at the top is NOT redundant — it's
 * actually necessary. Here's why: the loop only checks "next == n"
 * AFTER computing next = a + b (which starts at 1, not 0). If N were 0
 * and this special case were removed, the loop would generate next=1
 * on its first pass, immediately fail the "next <= n" condition
 * (1 <= 0 is false) on the very next check, and exit having NEVER
 * tested whether 0 itself is a Fibonacci number — incorrectly
 * returning false. The special case exists specifically to handle this
 * edge case correctly, since 0 is conventionally considered the first
 * Fibonacci number.
 *
 * NOTE: The local variable "next" is initialized to 0 before the loop,
 * but that initial value is never actually used for comparison — it
 * gets overwritten as soon as the loop runs. It's just there to satisfy
 * Java's requirement that local variables be initialized before use.
 *
 * Example:
 * Input:  n = 0
 * Output: true
 */
public class FibonacciNumberInRange {

	public static boolean findFibonacci(int n) {

		int a=0;
		int b=1;
		int next=0;

		if(n==0)
			return true; // required special case — see note above

		while(next<=n) {
			next=a+b;
			a=b;
			b=next;
			if(next==n)
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int n=0;
		System.out.println(findFibonacci(n));
	}

}