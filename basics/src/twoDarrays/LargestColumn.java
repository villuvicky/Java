package twoDarrays;

import java.util.Scanner;

public class LargestColumn {
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

	public static void largestRowOrColumn(int[][] arr) {
		
		if (arr == null || arr.length == 0) {
	           // System.out.println("row 0 " + Integer.MIN_VALUE);
	            return;
	        }

        int n = arr.length;        // rows
        int m = arr[0].length;     // columns

        int maxSum = Integer.MIN_VALUE;
        int index = 0;
        String type = "row";

        // Step 1: Check all rows
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < m; j++) {
                rowSum += arr[i][j];
            }

            if (rowSum > maxSum) {
                maxSum = rowSum;
                index = i;
                type = "row";
            }
        }

        // Step 2: Check all columns
        for (int j = 0; j < m; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += arr[i][j];
            }

            // strictly greater only
            if (colSum > maxSum) {
                maxSum = colSum;
                index = j;
                type = "column";
            }
        }

        // Output
        System.out.println(type + " " + index + " " + maxSum);
    }
	
	public static void main(String[] args) {
		
	largestRowOrColumn(takeInput());

	}

}
