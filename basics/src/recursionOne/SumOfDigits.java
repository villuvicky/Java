package recursionOne;

public class SumOfDigits {
public static int number(int n) {
		
		if(n==0)
			return 0;
		
		return number(n/10)+(n%10);
		
	}
	

	

	public static void main(String[] args) {
		
		System.out.println(number(1234));

	}

}
