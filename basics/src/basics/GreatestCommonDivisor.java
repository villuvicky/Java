package basics;

public class GreatestCommonDivisor {
	
	
	public static int primeFactor(int a, int b) {
		
		 while (b != 0) {
	            int remainder = a % b;
	            a = b;
	            b = remainder;
	        }
	        return a;
	}

	public static void main(String[] args) {
		
		System.out.println(primeFactor(20, 4));
	}

}
