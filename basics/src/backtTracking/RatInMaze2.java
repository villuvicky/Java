package backtTracking;

public class RatInMaze2 {
	   // Top, Down, Left, Right
    static int[] rowDir = {-1, 1, 0, 0};
    static int[] colDir = {0, 0, -1, 1};

    public static void printAllPaths(int[][] maze, int n) {

        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return;
        }

        int[][] path = new int[n][n];

        solve(maze, path, 0, 0, n);
    }

    private static void solve(int[][] maze,
                              int[][] path,
                              int row,
                              int col,
                              int n) {

        // Invalid cell
        if (row < 0 || col < 0 || row >= n || col >= n ||
                maze[row][col] == 0 || path[row][col] == 1) {
            return;
        }

        // Mark current cell
        path[row][col] = 1;

        // Destination reached
        if (row == n - 1 && col == n - 1) {

            // Print path matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(path[i][j] + " ");
                }
            }

            System.out.println();

            // Backtrack
            path[row][col] = 0;
            return;
        }

        // Top
        solve(maze, path, row - 1, col, n);

        // Down
        solve(maze, path, row + 1, col, n);

        // Left
        solve(maze, path, row, col - 1, n);

        // Right
        solve(maze, path, row, col + 1, n);

        // Backtracking
        path[row][col] = 0;
    }

    public static void main(String[] args) {

        int[][] maze = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };

        int n = maze.length;

        printAllPaths(maze, n);
    }
}
