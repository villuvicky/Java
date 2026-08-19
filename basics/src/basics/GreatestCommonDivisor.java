package basics;

/*
 * Q1: Given two integers A and B, find their Greatest Common Divisor
 * (GCD) — the largest number that divides both A and B exactly —
 * using the Euclidean algorithm.
 *
 * Approach: Repeatedly replace (a, b) with (b, a % b) until b becomes 0.
 * At that point, a holds the GCD.
 *
 * NOTE ON THE METHOD NAME: This method is named "primeFactor", but it
 * does NOT compute prime factors — it computes the GREATEST COMMON
 * DIVISOR using the Euclidean algorithm. This is a misleading name left
 * over from the class name; consider renaming it to something like
 * "gcd" to avoid confusion when reading or reusing this code later.
 *
 * Trace for primeFactor(20, 4):
 * a=20, b=4  -> remainder = 20 % 4 = 0 -> a=4, b=0
 * b is now 0, loop ends -> return a = 4
 *
 * Output: 4
 */
public class GreatestCommonDivisor {
	
	
	public static int primeFactor(int a, int b) {
		
		 while (b != 0) {
	            int remainder = a % b;
	            a = b;
	            b = remainder;
	        }
	        return a;
	}

	public static void main(String[] args) {
		
		System.out.println(primeFactor(20, 4));
	}

}