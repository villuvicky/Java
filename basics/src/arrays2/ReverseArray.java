package arrays2;

import java.util.Scanner;

public class ReverseArray {
	
	public static void reverse(int [] A) {
		
		int right=A.length-1;
		int left=0;
		while(left<right) {
			
			int temp=A[left];
			A[left]=A[right];
			A[right]=temp;
			left++;
			right--;
		}
	}
	
	
	public static int takeInput(String str) {

		System.out.println(str);
		Scanner sc= new Scanner(System.in);
		return sc.nextInt();
	}

	public static void main(String[] args) {
		int capacity=takeInput("Enter capacity");

		int A[]=new int[capacity];

		for (int i=0; i<capacity;i++) {
			A[i]=takeInput("Enter value");
		}

		
		reverse(A);
		for (int i : A) {
			System.out.println(i+" ");
		}


	}

}
