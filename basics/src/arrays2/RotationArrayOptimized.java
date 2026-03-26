package arrays2;

import java.util.Scanner;

public class RotationArrayOptimized {
	
	
	public static void reverse(int A[],int left, int right) {
		while(left<right) {
		int temp=A[left];
		A[left]=A[right];
		A[right]=temp;
		left++;
		right--;
		}
	}

	public static void direction(int arr[], int rotation, int x) {
		int len=arr.length;
		if(rotation==1) {
			reverse(arr,0,len-1);
			reverse(arr, 0, x-1);
			reverse(arr, x, len-1);
		}
		else {
			reverse(arr,0,len-1);
			reverse(arr, 0, len-x-1);
			reverse(arr, len-x, len-1);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int A[]= {1,2,3,4,5,6,7,8};
		System.out.println("Enter 1 to right rotation and 0 to left");
		int rotation=sc.nextInt();

		System.out.println("Enter number of rotations");
		int x=sc.nextInt();
		
		direction(A, rotation, x);
		
		for (int i : A) {
			System.out.print(i+" ");
		}

	}

}
