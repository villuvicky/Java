package patterns;

public class HourGlass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=7;
		for(int i=1;i<=n;i++) {

			for(int j=1;j<=i-1;j++) {
				System.out.print(" ");
			}
			for(int j=i;j<=n;j++) {

				System.out.print(j+" ");
			}
			System.out.println();
		}

		for(int i=n-1;i>=1;i--) {

			for(int j=1;j<=i-1;j++) {
				System.out.print(" ");
			}
			for(int j=i;j<=n;j++) {

				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

}




