package twoDarrays;

public class PrintLikeWave {  public static void sineWave(int[][] arr) {

    // Edge case: no rows
    if (arr == null || arr.length == 0) {
        return;
    }

    int n = arr.length;        // rows
    int m = arr[0].length;     // columns

    for (int col = 0; col < m; col++) {

        // Even column → top to bottom
        if (col % 2 == 0) {
            for (int row = 0; row < n; row++) {
                System.out.print(arr[row][col] + " ");
            }
        }
        // Odd column → bottom to top
        else {
            for (int row = n - 1; row >= 0; row--) {
                System.out.print(arr[row][col] + " ");
            }
        }
    }

    System.out.println();
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
