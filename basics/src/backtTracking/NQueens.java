package backtTracking;

public class NQueens {

	public static void placeNQueens(int n) {
        int[][] board = new int[n][n];
        solve(board, 0, n);
    }

    private static void solve(int[][] board, int row, int n) {

        // All queens are placed successfully
        if (row == n) {
            printBoard(board, n);
            return;
        }

        // Try placing queen in every column of current row
        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;      // Place queen
                solve(board, row + 1, n); // Recur for next row
                board[row][col] = 0;      // Backtrack
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col, int n) {

        // Check same column in previous rows
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void printBoard(int[][] board, int n) {

        // Print in a single line as required by most coding platforms
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4;
        placeNQueens(n);
    }

}
