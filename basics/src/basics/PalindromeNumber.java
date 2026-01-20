package basics;

public class PalindromeNumber {


	public static int palindrome(int n) {

		int reversedNumber=0;

		while(n>0) {

			int remainder=n%10;
			reversedNumber=reversedNumber*10+remainder;
			n=n/10;
		}

		return reversedNumber;
	}

	public static void main(String[] args) {
		int n=1;
		if(palindrome(n)==n)
			System.out.println(true);
		else
			System.out.println(false);
	}

}
