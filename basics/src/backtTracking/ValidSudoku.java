package backtTracking;

public class ValidSudoku {
	  public static boolean isItSudoku(int[][] matrix) {
	return solve(matrix);
}

private static boolean solve(int[][] board) {

	// Find the next empty cell (value 0)
	for (int row = 0; row < 9; row++) {
		for (int col = 0; col < 9; col++) {

			if (board[row][col] == 0) {

				// Try digits 1 to 9
				for (int num = 1; num <= 9; num++) {

					if (isSafe(board, row, col, num)) {

						// Place the digit
						board[row][col] = num;

						// Recur for remaining cells
						if (solve(board)) {
							return true;
						}

						// Backtrack
						board[row][col] = 0;
					}
				}

				// No valid digit can be placed here
				return false;
			}
		}
	}

	// No empty cells left => Sudoku solved
	return true;
}

private static boolean isSafe(int[][] board,
		int row,
		int col,
		int num) {

	// Check row
	for (int j = 0; j < 9; j++) {
		if (board[row][j] == num) {
			return false;
		}
	}

	// Check column
	for (int i = 0; i < 9; i++) {
		if (board[i][col] == num) {
			return false;
		}
	}

	// Check 3x3 subgrid
	int startRow = (row / 3) * 3;
	int startCol = (col / 3) * 3;

	for (int i = startRow; i < startRow + 3; i++) {
		for (int j = startCol; j < startCol + 3; j++) {
			if (board[i][j] == num) {
				return false;
			}
		}
	}

	return true;
}

// Optional main method for testing
public static void main(String[] args) {

	int[][] matrix = {
			{3,0,6,5,0,8,4,0,0},
			{5,2,0,0,0,0,0,0,0},
			{0,8,7,0,0,0,0,3,1},
			{0,0,3,0,1,0,0,8,0},
			{9,0,0,8,6,3,0,0,5},
			{0,5,0,0,9,0,6,0,0},
			{1,3,0,0,0,0,2,5,0},
			{0,0,0,0,0,0,0,7,4},
			{0,0,5,2,0,6,3,0,0}
	};

	System.out.println(isItSudoku(matrix)); // true
}
}
