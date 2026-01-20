package twoDarrays;

import java.util.Scanner;

public class PrintDiagonal {

	public static int[][] takeInput() {

		Scanner sc= new Scanner(System.in);
		System.out.println("Enter no of rows: ");
		int r=sc.nextInt();
		System.out.println("Enter no of rows: ");
		int c=sc.nextInt();
		int arr[][]=new int[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print("enter elemt at A["+i+"]["+j+"]");
				arr[i][j]=sc.nextInt();
			}
			System.out.println();
		}
		return arr;
	}


	public static void printDiagonal(int[][] arr) {
		int row=arr.length;
		int column=arr[0].length;

		if(row!=column) {
			System.out.println("NO");
			return;
		}
		System.out.println("YES");
		int [] squareValues= new int[row];
		for(int i=0;i<row;i++) {
			squareValues[i]=arr[i][i];
			System.out.println(arr[i][i]);
		}
	}

	public static void main(String[] args) {

		printDiagonal(takeInput());

	}

}
