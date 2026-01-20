package arrays2;

public class SumOfTwoArrays {


	public static void sum(int arr1[], int arr2[], int output[]) {

		int i=arr1.length-1;
		int j=arr2.length-1;
		int k=output.length-1;

		int carry=0;

		while(i>=0&&j>=0) {

			int sum=carry+arr1[i]+arr2[j];
			output[k]=sum%10;
			carry=sum/10;
			System.out.println("i is "+i);
			System.out.println("j is "+j);
			i--;
			j--;
			k--;

		}
		if(i>j) {
			//i=i+1;
			while(i>=0) {
				int sum=carry+arr1[i];
				output[k]=sum%10;
				carry=sum/10;
				i--;
				k--;
			}
		}
		else {
			//j=j+1;
			while(j>=0) {
				int sum=carry+arr2[j];
				output[k]=sum%10;
				carry=sum/10;
				j--;
				k--;
			}
		}
		if (carry > 0) {
	        output[k] = carry;
	    }

	}

	public static void main(String[] args) {

		int [] arr1= {6,9,8};
		int [] arr2= {5,9,2};

		int k=0;
		if(arr1.length>arr2.length) {
			k=arr1.length+1;
		}
		else
		{
			k=arr2.length+1;	
		}
		int [] output= new int[k];

		sum(arr1, arr2, output);
		for (int ii : output) {
			System.out.print(ii+" ");
		}
	}

}
