package recursionOne;

public class NumberOfDigits {
	
	public static int number(int n) {
		
		if(n==0)
			return 0;
		
		return 1+number(n/10);
		
	}
	

	

	public static void main(String[] args) {
		
		System.out.println(number(1234));

	}

}
