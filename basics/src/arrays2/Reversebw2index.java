package arrays2;

import java.util.Scanner;

public class Reversebw2index {

	public static void reverse(int [] A,int left,int right) {

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
		int left=takeInput("Enter left");
		int right=takeInput("Enter right");

		reverse(A,left,right);
		for (int i : A) {
			System.out.println(i+" ");
		}


	}

}
