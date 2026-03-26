package recursionOne;

public class Factorial {
	
	
	public static int factorial(int n) {
		
		if(n==0)
			return 1;
		
		int currentFact=factorial(n-1);
		int total=n*currentFact;
		return total;
		
		
	}
	
	

	public static void main(String[] args) {
		
		System.out.println(factorial(5));
		

	}

}
