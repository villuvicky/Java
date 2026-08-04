package graphs;
import java.util.Scanner;
public class LargestPiece {



	    static int[][] dir = {
	        {1, 0},
	        {-1, 0},
	        {0, 1},
	        {0, -1}
	    };

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        int n = sc.nextInt();

	        String[] board = new String[n];

	        for (int i = 0; i < n; i++) {
	            board[i] = sc.next();
	        }

	        System.out.println(dfs(board, n));

	        sc.close();
	    }

	    public static int dfs(String[] edge, int n) {

	        boolean[][] visited = new boolean[n][n];
	        int max = 0;

	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {

	                if (edge[i].charAt(j) == '1' && !visited[i][j]) {
	                    max = Math.max(max, helper(edge, visited, i, j, n));
	                }
	            }
	        }

	        return max;
	    }

	    static int helper(String[] edge, boolean[][] visited,
	                      int row, int col, int n) {

	        visited[row][col] = true;
	        int count = 1;

	        for (int k = 0; k < 4; k++) {

	            int newRow = row + dir[k][0];
	            int newCol = col + dir[k][1];

	            if (newRow >= 0 && newRow < n &&
	                newCol >= 0 && newCol < n &&
	                edge[newRow].charAt(newCol) == '1' &&
	                !visited[newRow][newCol]) {

	                count += helper(edge, visited, newRow, newCol, n);
	            }
	        }

	        return count;
	    }
	}
