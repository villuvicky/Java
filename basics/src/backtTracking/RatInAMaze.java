package backtTracking;

public class RatInAMaze {

	static int[] rowDir = {-1, 1, 0, 0}; // up, down
    static int[] colDir = {0, 0, -1, 1}; // left, right

    public static boolean ratInMaze(int[][] maze, int n) {

        // If start or end blocked
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return false;
        }

        boolean[][] visited = new boolean[n][n];

        return dfs(maze, visited, 0, 0, n);
    }

    private static boolean dfs(int[][] maze,
                               boolean[][] visited,
                               int row,
                               int col,
                               int n) {

        // Mark current cell in path
        visited[row][col] = true;

        // Destination reached
        if (row == n - 1 && col == n - 1) {

            System.out.println("Path Matrix:");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        System.out.print("1 ");
                    } else {
                        System.out.print("0 ");
                    }
                }
                System.out.println();
            }

            return true;
        }

        // Explore 4 directions
        for (int i = 0; i < 4; i++) {

            int newRow = row + rowDir[i];
            int newCol = col + colDir[i];

            if (isValid(maze, visited, newRow, newCol, n)) {

                if (dfs(maze, visited, newRow, newCol, n)) {
                    return true;
                }
            }
        }

        // Backtrack
        visited[row][col] = false;

        return false;
    }

    private static boolean isValid(int[][] maze,
                                   boolean[][] visited,
                                   int row,
                                   int col,
                                   int n) {

        return (row >= 0 &&
                col >= 0 &&
                row < n &&
                col < n &&
                maze[row][col] == 1 &&
                !visited[row][col]);
    }

    public static void main(String[] args) {

        int[][] maze = {
                {1, 0, 1},
                {1, 1, 1},
                {0, 1, 1}
        };

        int n = maze.length;

        boolean ans = ratInMaze(maze, n);

        System.out.println("Path Exists: " + ans);
    }
	}

