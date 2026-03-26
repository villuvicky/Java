package arrays;

import java.util.Scanner;

public class UniqueNumber {

	public static int unique(int arr[]) {

		int n=arr.length;

		for(int i=0;i<n;i++) {
			int count=0;
			for(int j=0;j<n;j++) {
				if(arr[i]==arr[j])
					count++;
			}
			if(count<2) {
				System.out.println(arr[i]);
				return arr[i];
			}
		}
		return 0;
		
		
	}
	
	public static int unique2(int arr[]) {
		
		 int result = 0;

	        for (int num : arr) {
	            result^= num;
	        }

	        return result;
	}

	public static void main(String[] args) {


		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();

		int arr[]= new int[n];

		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		unique(arr);
		System.out.println(unique2(arr));
	}

}
