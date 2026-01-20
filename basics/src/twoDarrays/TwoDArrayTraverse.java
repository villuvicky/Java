package twoDarrays;

public class TwoDArrayTraverse {

	public static void main(String[] args) {
		
		int A[][]= { {1, 2, 3}, {4, 5, 6} };
		int n = A.length;        // number of rows
        int m = A[0].length;
		int A1[]= new int [n*m];
		int index=0;
		for(int i=0;i<A.length;i++) {
			
			for(int j=0;j<A[i].length;j++) {
				System.out.print(A[i][j]+" ");
				A1[index]=A[i][j];
				index++;
				
			}
			
		}
		
	}

}
