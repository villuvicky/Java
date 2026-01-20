package arrays;

import java.util.Scanner;

public class MinimumNumber {


	public static int minimum_element(int[] arr){
		
		int minimum=arr[0];
		for (int i : arr) {
			if(i<minimum) {
				minimum=i;
			}
		}
		return minimum;
	}

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();

		int arr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(minimum_element(arr));
	}

}
