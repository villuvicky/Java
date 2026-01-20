package arrays2;

public class PrefixSum {

	public static void main(String[] args) {
		
		
		int [] arr= {1,2,3,4,5};
		int lenght=arr.length;
		int [] sum=new int [lenght];
		sum[0]=arr[0];
		int start=1;
		
		while(start<lenght) {
			
			sum[start]=sum[start-1]+arr[start];
			start++;
			
		}
		for (int i : sum) {
			System.out.println(i);
		}

	}

}
