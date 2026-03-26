package recursionOne;

public class MultiplicationRecursive {
	
	public static int recursive(int m, int n) {
		
		if(n==0)
			return 0;
		
		return m+recursive(m, n-1);
	}

	public static void main(String[] args) {
		
		int m=5;
		int n=5;
		System.out.println(recursive(m, n));

	}

}
