package basics;

/*
 * Q1: Print a temperature conversion table from Fahrenheit to Celsius,
 * for a range of Fahrenheit values from "start" to "end", incrementing
 * by "step" each time, using the conversion formula:
 *
 *     C = (F - 32) * 5 / 9
 *
 * IMPORTANT NOTE ON INTEGER DIVISION: Since "formula" is declared as an
 * int and all operands ((i-32)*5 and 9) are ints, Java performs INTEGER
 * division here, which TRUNCATES any decimal part (toward zero) instead
 * of rounding. For example, 0°F should convert to about -17.78°C, but
 * this program prints -17 (the decimal part is simply cut off, not
 * rounded to the nearest whole number). If more accurate results were
 * needed, you'd declare "formula" as a double and cast at least one
 * operand to double (e.g. "(i - 32) * 5.0 / 9").
 *
 * Example:
 * Input:  start = 0, end = 100, step = 20
 * Output:
 * 0 -17
 * 20 -6
 * 40 4
 * 60 15
 * 80 26
 * 100 37
 */
public class FarenheitToCelcius {


	public static void printFahrenheitTable(int start, int end, int step) {

		for(int i=start; i<=end;i+=step){
			int formula=(i-32)*5/9; // integer division truncates decimals (see note above)
			System.out.print(i+" ");
			System.out.print(formula);
			System.out.println();
		}
	}

	public static void main (String[] args) {
		printFahrenheitTable(0, 100, 20);
	}

}