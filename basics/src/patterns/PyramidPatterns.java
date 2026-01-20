package patterns;

public class PyramidPatterns {

	public static void main(String[] args) {


		int n =4;

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*"+" ");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println();


		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();


		System.out.println();


		int count=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				count =count+1;
				System.out.print(count);
			}
			System.out.println();
		}

		System.out.println();
		System.out.println();


		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();


		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();

		for (int i = 1; i <= n; i++) {

			// Print leading spaces
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}

			// Print numbers
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}

			// Move to next line
			System.out.println();

		}



		System.out.println();
		System.out.println();


		for(int i=1;i<=n;i++){

			for(int j=i;j>=1;j--){
				System.out.print(j);
			}
			System.out.println();
		}

		for(int i=1;i<=n;i++) {

			for(int j=1;j<i;j++) {
				System.out.print(" ");
			}
			for(int j=i;j<=n;j++) {
				System.out.print("* ");
			}

			System.out.println();
		}


		System.out.println();
		System.out.println();

		for(int i=1;i<=n;i++) {

			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println();
		for (int i = 0; i < n; i++) {
			int number = 1;


			for (int space = 0; space < n - i - 1; space++) {
				System.out.print(" ");
			}


			for (int j = 0; j <= i; j++) {
				System.out.print( number+" " );
				number = number * (i - j) / (j + 1);
			}

			System.out.println();
		}
	}
}