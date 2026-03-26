package arrays;

import java.util.Scanner;

public class DuplicateNumber {

	public static int duplicate(int arr[]) {

		int n=arr.length;

		for(int i=0;i<n;i++) {
			int count=0;
			for(int j=0;j<n;j++) {
				if(arr[i]==arr[j])
					count++;
			}
			if(count>1) {
				//System.out.println(arr[i]);
				return arr[i];
			}
		}
		return 0;
		
	}
	

	    public static int findDuplicate(int[] arr) {
	        int xor = 0;

	        // XOR all elements of array
	        for (int num : arr) {
	            xor ^= num;
	        }

	        // XOR numbers from 0 to N-2
	        for (int i = 0; i <= arr.length - 2; i++) {
	            xor ^= i;
	        }

	        return xor;
	    }

	    
	     
	 

	public static void main(String[] args) {

		/*
		 * Scanner sc= new Scanner(System.in); int n=sc.nextInt();
		 * 
		 * int arr[]= new int[n];
		 * 
		 * for(int i=0;i<n;i++) { arr[i]=sc.nextInt(); } duplicate(arr);
		 */
		   int[] arr2 = {0, 1, 2, 3, 2};
	        System.out.println(findDuplicate(arr2)); // Output: 2
	}

}
