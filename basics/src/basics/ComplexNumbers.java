package basics;

/*
 * Q1: Model a complex number (real + imaginary part) as a class with
 * methods to add and multiply it with another complex number, and to
 * print it in "real + iImaginary" form.
 *
 * Multiplication formula used (standard complex multiplication):
 *   (a + bi) * (c + di) = (ac - bd) + (ad + bc)i
 *
 * IMPORTANT NOTE: Both plus() and multiply() MUTATE the object they are
 * called on ("this") instead of returning a new ComplexNumbers instance.
 * That means after calling c1.plus(c2), c1's own real/imaginary fields
 * have permanently changed — c2 is left untouched, but the ORIGINAL
 * value of c1 is gone. This is a common design choice for simple
 * calculator-style programs, but it's worth being intentional about it:
 * if you needed to preserve the original c1 (e.g. to reuse it in
 * multiple operations), you'd want these methods to return a NEW
 * ComplexNumbers object instead of modifying "this" in place.
 */
public class ComplexNumbers {

	int real;
	int imaginary;

	public ComplexNumbers(int r, int i) {
		this.real=r;
		this.imaginary=i;
	}

	// adds c1 into this complex number, mutating "this" (see note above)
	public void plus(ComplexNumbers c1) {

		this.real=this.real+c1.real;
		this.imaginary=this.imaginary+c1.imaginary;

	}

	public void print() {
		System.out.println(this.real+" + i"+this.imaginary);
	}

	// multiplies this complex number by c2, mutating "this" (see note above)
	public void multiply(ComplexNumbers c2) {
		int newReal = (this.real * c2.real) - (this.imaginary * c2.imaginary);
		int newImaginary = (this.real * c2.imaginary) + (this.imaginary * c2.real);

		this.real = newReal;
		this.imaginary = newImaginary;
	}

}