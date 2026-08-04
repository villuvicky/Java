package backtTracking;

public class WordSearch {

	  public static boolean isWordExist(char[][] board, String word) {
	        int n = board.length;
	        int m = board[0].length;

	        boolean[][] visited = new boolean[n][m];

	        // Try starting from every cell
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                if (search(board, word, i, j, 0, visited)) {
	                    return true;
	                }
	            }
	        }

	        return false;
	    }

	    private static boolean search(char[][] board,
	                                  String word,
	                                  int row,
	                                  int col,
	                                  int index,
	                                  boolean[][] visited) {

	        int n = board.length;
	        int m = board[0].length;

	        // All characters matched
	        if (index == word.length()) {
	            return true;
	        }

	        // Invalid cell or character mismatch
	        if (row < 0 || col < 0 || row >= n || col >= m ||
	                visited[row][col] ||
	                board[row][col] != word.charAt(index)) {
	            return false;
	        }

	        // Mark current cell as used
	        visited[row][col] = true;

	        // Explore 4 directions: Up, Down, Left, Right
	        boolean found =
	                search(board, word, row - 1, col, index + 1, visited) || // Up
	                search(board, word, row + 1, col, index + 1, visited) || // Down
	                search(board, word, row, col - 1, index + 1, visited) || // Left
	                search(board, word, row, col + 1, index + 1, visited);   // Right

	        // Backtrack
	        visited[row][col] = false;

	        return found;
	    }

	    public static void main(String[] args) {

	        char[][] board = {
	                {'A', 'B', 'C', 'E'},
	                {'S', 'F', 'C', 'S'},
	                {'A', 'D', 'E', 'E'}
	        };

	        String word = "ABCCED";

	        System.out.println(isWordExist(board, word)); // true
	    }

}
