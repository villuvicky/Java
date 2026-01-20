package arrays2;

import java.util.Scanner;

public class PushPositives {

	public static void swap(int []A, int z, int nz) {
		int temp=A[z];
		A[z]=A[nz];
		A[nz]=temp;
	}

	public static void pushPositives(int []A) {
		int n=0;
		int p=0;
		while(p<A.length) {
			if(A[p]<0) {
				swap(A, p, n);
				n++;
			}
			p++;
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
		pushPositives(A);
		for (int i : A) {
			System.out.println(i+" ");
		}
	}

}
