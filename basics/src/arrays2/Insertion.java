package arrays2;

import java.util.Scanner;

public class Insertion {

	public static int takeInput(String str) {

		System.out.println(str);
		Scanner sc= new Scanner(System.in);
		return sc.nextInt();
	}
	public static void insert(int []A, int position ,int newValue,int size) {
		
		for(int i=size;i>position;i--) {
			A[i]=A[i-1];
		}
		
		A[position]=newValue;
		size++;

	}
	public static void main(String[] args) {

		int capacity=takeInput("Enter capacity");
		int size=takeInput("Enter size");

		int A[]=new int[capacity];

		for (int i=0; i<size;i++) {
			A[i]=takeInput("Enter value");
		}

		int position=takeInput("Enter position");
		int newValue=takeInput("Enter new value");
		insert(A, position, newValue,size);
		for (int i : A) {
			System.out.println(i+" ");
		}

	}

}
