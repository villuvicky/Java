package arrays2;

import java.util.Scanner;

public class RotationArray {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int A[]= {1,2,3,4,5,6,7,8};

		System.out.println("Enter 1 to right rotation and 0 to left");
		int rotation=sc.nextInt();

		System.out.println("Enter number of rotations");
		int x=sc.nextInt();
		int len=A.length;

		int B[] = new int [len];

		if(rotation==1) {

			for(int i=0;i<len;i++) {

				B[(i+x)%len]=A[i];
			}
		}
		else {
			for(int i=0;i<len;i++) {

				B[(i-x+len)%len]=A[i];
			}
		}

		for (int i : B) {
			System.out.print(i+" ");
		}


	}

}
