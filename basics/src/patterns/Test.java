package patterns;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=2;
		int num=1;

		for(int i=n+1;i>1;i--) {
			num=i-1;
			for(int j=1;j<i;j++) {
				System.out.print(num);
				num--;
			}
			System.out.println();
		}

		for(int i=2;i<=n;i++) {
			num=i;
			for(int j=1;j<=i;j++) {
				System.out.print(num);
				num--;
			}
			System.out.println();
		}
		
		
		

	
		for(int i=1;i<=n;i++) {
			char ch='A';
			for(int j=1;j<=i;j++) {
				
				System.out.print(ch);
				//ch=(char) (ch+1);
				ch++;
			}
			System.out.println();
		}
		
		
		
		for (int i = 1; i <= n; i++) {
            for (int j = n; j >= 1; j--) {
                // Print '*' at the sliding position
                if (j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(j);
                }
            }
            System.out.println();
        }
	}

}
