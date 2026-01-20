package basics;

public class FibonacciNumberInRange {

	public static boolean findFibonacci(int n) {

		int a=0;
		int b=1;
		int next=0;
		
		if(n==0)
			return true;
		while(next<=n) {
			next=a+b;
			a=b;
			b=next;
			if(next==n)
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int n=0;
		System.out.println(findFibonacci(n));
	}

}
