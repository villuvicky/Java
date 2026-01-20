package basics;


import java.util.Scanner;

public class Permutations {

	public static int permutation(int n, int r) {
		int factN = facto(n);
		int factNR = facto(n-r);
		int perm = factN/factNR;
		return perm;
	}

	public static int facto(int v) {
		int fact = 1;

		for (int i = v; i > 0; i--) {
			fact = fact*i;
		}
		return fact;
	}

	public static int checkValue(int n, int r)
	{

		if (r < 0 || n < 0 || r > n) {
			return -1;
		}

		else
			return 1;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int r = sc.nextInt();
		int diff=checkValue(n, r);
		if(diff>0)
		{
			System.out.println(permutation(n, r));
		}
		else {

			System.out.println(diff);}
	}






}
