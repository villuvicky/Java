package patterns;

public class TrianglePatterns1 {

	public static void main(String[] args) {
		int n =4;

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("*****************");

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}

		System.out.println("*****************");
		int count=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(i+j-1);
			}
			System.out.println();
		}


		System.out.println("*****************");
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(count=count+1);
			}
			System.out.println();
		}
		
		 for(int i=1;i<=n;i++) {
				for(int j=1;j<=i;j++) {
					System.out.print(n-j+1+" ");
				}
				System.out.println();
		}
		 
		 for(int i=1;i<=n;i++){
				
				for(int j=1;j<i;j++) {

					System.out.print(" ");
				}

				for(int j=i;j<=n;j++) {

					System.out.print("*");
				}


				System.out.println();
			}
	}

}
