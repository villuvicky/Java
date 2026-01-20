package basics;

import java.util.Scanner;
public class UnitTesting{

	public static int calculateSimple(int principal, double rate, int time) {
	       
		int interest=(int) (principal*rate*time/100);
		return interest;

		    }

	public static void main (String[] args) {
		System.out.println(calculateSimple(2000, 2.2, 4));
	}

}
