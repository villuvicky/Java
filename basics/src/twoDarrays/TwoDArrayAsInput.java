package twoDarrays;

import java.util.Scanner;

public class TwoDArrayAsInput {
	
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

	public static void main(String[] args) {
		int arr[][]=takeInput();
		
	}

}
