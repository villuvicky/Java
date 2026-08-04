package graphs;

import java.util.Scanner;

public class ConnectingDots {
	 int[] dx = {-1, 1, 0, 0};
	    int[] dy = {0, 0, -1, 1};

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        int n = sc.nextInt();
	        int m = sc.nextInt();

	        String[] board = new String[n];

	        for (int i = 0; i < n; i++) {
	            board[i] = sc.next();
	        }

	        ConnectingDots obj = new ConnectingDots();
	        System.out.println(obj.solve(board, n, m));

	        sc.close();
	    }

	    int solve(String[] board, int n, int m) {

	        boolean[][] visited = new boolean[n][m];

	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {

	                if (!visited[i][j]) {

	                    if (dfs(board, visited, i, j, -1, -1, 1, n, m)) {
	                        return 1;
	                    }
	                }
	            }
	        }

	        return 0;
	    }

	    boolean dfs(String[] board, boolean[][] visited,
	                int row, int col,
	                int parentRow, int parentCol,
	                int length, int n, int m) {

	        visited[row][col] = true;

	        for (int k = 0; k < 4; k++) {

	            int newRow = row + dx[k];
	            int newCol = col + dy[k];

	            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m)
	                continue;

	            if (board[newRow].charAt(newCol) != board[row].charAt(col))
	                continue;

	            if (newRow == parentRow && newCol == parentCol)
	                continue;

	            if (visited[newRow][newCol]) {
	                if (length >= 4)
	                    return true;
	            } else {
	                if (dfs(board, visited, newRow, newCol,
	                        row, col, length + 1, n, m))
	                    return true;
	            }
	        }

	        return false;
	    }
}
