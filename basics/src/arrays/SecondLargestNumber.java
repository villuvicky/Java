package arrays;

import java.util.Scanner;

public class SecondLargestNumber {
	
	public static int secondLargest_element(int arr[],int n) {
		
		int large=Integer.MIN_VALUE;;
		int secondLarge=Integer.MIN_VALUE;;
		 for (int i : arr) {
			 
			 if(i>large) {
				 secondLarge=large;
				 large=i;
			 }
			 else if(i>secondLarge&&i!=large) {
				 secondLarge = i;
			 }
			
		}
		return secondLarge;
	}
	

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();

		int arr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(secondLargest_element(arr,n));
	}

}
