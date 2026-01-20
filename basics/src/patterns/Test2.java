package patterns;

public class Test2 {

	public static void main(String[] args) {

		int n = 552245;
		int odd=0;
		int even=0;

		while(n>0) {

			int reminder=n%10;
			System.out.println(reminder);
			
			if(reminder%2==0) {
				System.out.println(reminder +" is even");
				even=even+reminder;
			}
			else {
				odd=odd+reminder;
				System.out.println(reminder +" is odd");
			}
			n=n/10;

		}

		System.out.println(even+" "+odd);

	}

}
