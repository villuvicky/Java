package patterns;

public class InvertedTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=5;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}



		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i+1;j++) {
				System.out.print(n-i+1);
			}
			System.out.println();
		}



		for(int i=1;i<=n;i++) {

			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			int num=i;
			for(int j=1;j<=i;j++) {
				System.out.print(num);
				num++;
			}
			num=num-2;
			for(int j=1;j<i;j++) {
				System.out.print(num);
				num--;
			}

			System.out.println();
		}


		for(int i=1;i<=n;i++) {

			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {

				System.out.print(j);
			}

			int num=i-1;
			for(int j=1;j<i;j++) {
				System.out.print(num);
				num--;
			}
			System.out.println();
		}
	}
}
