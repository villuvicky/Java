package arrays;

import java.util.Scanner;

public class MaximumNumber {


	public static int maximum_element(int[] arr, int n){
		
		int maximum=arr[0];
		for (int i : arr) {
			if(i>maximum) {
				maximum=i;
			}
		}
		return maximum;
	}

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();

		int arr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(maximum_element(arr,n));
	}
}
