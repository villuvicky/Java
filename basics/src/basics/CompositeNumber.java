package basics;

public class CompositeNumber {
	
	public  static void composite(int n) {
		
		for (int i=2;i<=n;i++) {
			int count=1;
			for(int j=2;j<=i;j++) {
				if(i%j==0)
					count++;
			}
			
			if(count>2) {
				System.out.println(i);
			}
		}
		
	}

	public static void main(String[] args) {
	
		int n=15;
		composite(n);

	}

}
