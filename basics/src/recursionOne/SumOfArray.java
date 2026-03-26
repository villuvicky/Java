package recursionOne;

public class SumOfArray {
	
	
	public static int sumOfArray(int input[], int n) {
		
		
		if(n<0)
			return 0;

		return input[n]+sumOfArray(input,n-1);
	}
	

	public static void main(String[] args) {
		
		int input[]= {9,8,9};
		int n=input.length-1;
		System.out.println(sumOfArray(input, n));

	}

}
