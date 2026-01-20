package patterns;

public class SquareOfNumbers {

	public static void main(String[] args) {

		int n=4;

		for(int i=1;i<=n;i++) {

			for(int j=1;j<=n;j++) {
				System.out.print(i);
			}
			System.out.println();
		}

		System.out.println("*****************");

		for(int i=1;i<=n;i++) {

			for(int j=1;j<=n;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		System.out.println("*****************");

		for(int i=0;i<n;i++) {

			for(int j=0;j<n;j++) {
				System.out.print(n-j);
			}
			System.out.println();
		}
		System.out.println("*****************");

		for(int i=0;i<n;i++) {

			for(int j=0;j<n;j++) {
				System.out.print(n-i);
			}
			System.out.println();
		}
		
		System.out.println("*****************");
		
		
		for(int i=1;i<=n;i++) {
			int num=i;
			for(int j=1;j<=n;j++) {
				System.out.print(num+" ");
				num++;
				if(num>n) {
					num=1;
				}
			}
			System.out.println();
		}
		
		
		System.out.println("*****************");
		for(int i=1;i<=n;i++) {
			System.out.print(i);
		}
		System.out.println();

	
		for(int i=1;i<=n-2;i++) {
			System.out.print(1);
			for(int j=1;j<=n-2;j++) {
				System.out.print(" ");
			}
			System.out.print(2);
			System.out.println();
		}
		
		if(n>1) {
			for(int i=1;i<=n;i++) {
				System.out.print(i);
			}
			
		}
		System.out.println();
		
		System.out.println("*****************");
		int num=1;
		for(int i=1;i<=n;i++) {

			for(int j=1;j<=n;j++) {
				System.out.print(num+" ");
				num=num+1;
			}
			System.out.println();
		}
	}

}
