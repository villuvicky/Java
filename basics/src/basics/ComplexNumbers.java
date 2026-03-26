package basics;

public class ComplexNumbers {

	int real;
	int imaginary;

	public ComplexNumbers(int r, int i) {
		this.real=r;
		this.imaginary=i;
	}

	public void plus(ComplexNumbers c1) {

		this.real=this.real+c1.real;
		this.imaginary=this.imaginary+c1.imaginary;

	}

	public void print() {
		System.out.println(this.real+" + i"+this.imaginary);
	}
	public void multiply(ComplexNumbers c2) {
		int newReal = (this.real * c2.real) - (this.imaginary * c2.imaginary);
		int newImaginary = (this.real * c2.imaginary) + (this.imaginary * c2.real);

		this.real = newReal;
		this.imaginary = newImaginary;
	}

}
