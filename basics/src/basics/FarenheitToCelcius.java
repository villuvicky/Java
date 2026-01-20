package basics;

public class FarenheitToCelcius {


	public static void printFahrenheitTable(int start, int end, int step) {

		for(int i=start; i<=end;i+=step){
			int formula=(i-32)*5/9;
			System.out.print(i+" ");
			System.out.print(formula);
			System.out.println();
		}
	}

	public static void main (String[] args) {
		printFahrenheitTable(0, 100, 20);
	}

}
