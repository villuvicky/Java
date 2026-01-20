package arrays2;

import java.util.Scanner;

public class PushZero {

	public static void swap(int []A, int z, int nz) {
		int temp=A[z];
		A[z]=A[nz];
		A[nz]=temp;
	}

	public static void pushZeros(int []A) {
		int nz=0;
		int z=0;
		while(z<A.length) {
			if(A[z]!=0) {
				swap(A, z, nz);
				nz++;
			}
			z++;
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
		pushZeros(A);
		for (int i : A) {
			System.out.println(i+" ");
		}
	}
}
