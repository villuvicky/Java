package arrays2;

import java.util.Scanner;

public class Updation {
	
	public static void update(int[] A, int oldValue, int newValue) {
		for(int i=0;i<A.length;i++) {
			
			if(A[i]==oldValue) {
				A[i]=newValue;
				return;
			}
				
		}
		System.out.println("Key Not Found");
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

		int oldValue=takeInput("Enter old Value");
		int newValue=takeInput("Enter new value");
		update(A, oldValue, newValue);
		for (int i : A) {
			System.out.println(i+" ");
		}


	}

}
