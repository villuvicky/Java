package twoDarrays;

public class SumOfBoundariesAndDiagonal {

	public static void specialSum(int[][] mat) {

        int n = mat.length;

        // Edge case: 0x0 matrix
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // Check diagonal or boundary
                if (i == j ||                      // main diagonal
                    i + j == n - 1 ||              // secondary diagonal
                    i == 0 || i == n - 1 ||        // top or bottom row
                    j == 0 || j == n - 1) {        // left or right column

                    sum += mat[i][j];
                }
            }
        }

        System.out.println(sum);
	}
	
	public static void main(String[] args) {
		
	}
}
