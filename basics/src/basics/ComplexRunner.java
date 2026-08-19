package basics;

import java.util.Scanner;

/*
 * Q2: Write a driver/runner program that reads two complex numbers
 * (real and imaginary parts for each) plus a choice (1 = add, 2 =
 * multiply) from input, performs the chosen operation using the
 * ComplexNumbers class, and prints the result.
 *
 * NOTE: Because ComplexNumbers.plus()/multiply() mutate the object they
 * are called on (see the note in ComplexNumbers.java), calling
 * "c1.plus(c2)" here permanently overwrites c1 with the sum — c1's
 * original value is not preserved after this call. That's fine for a
 * one-shot runner like this, but keep it in mind if you ever needed to
 * perform multiple different operations using the original c1 value.
 *
 * NOTE: Any choice other than 1 or 2 falls into the "else" branch and
 * simply returns without printing anything — there's no explicit
 * "Invalid choice" message for unexpected input.
 *
 * Example:
 * Input: 2 3   1 4   1        (c1 = 2+3i, c2 = 1+4i, choice = add)
 * Output: 3 + i7
 */
public class ComplexRunner {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int real1 = s.nextInt();
		int imaginary1 = s.nextInt();

		int real2 = s.nextInt();
		int imaginary2 = s.nextInt();

		ComplexNumbers c1 = new ComplexNumbers(real1, imaginary1);
		ComplexNumbers c2 = new ComplexNumbers(real2, imaginary2);

		int choice = s.nextInt();

		 
		if(choice == 1) {
			// Add this passes c1 as this.value in constructor
			c1.plus(c2);
			
			c1.print();
		}
		else if(choice == 2) {
			// Multiply
			c1.multiply(c2);
			c1.print();
		}
		else {
			return;
		}

	}

}