package graphs;

import java.util.Scanner;

public class MakeSentence {



    static String target = "CODINGNINJA";

    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        String[] graph = new String[N];

        for (int i = 0; i < N; i++) {
            graph[i] = sc.next();
        }

        MakeSentence obj = new MakeSentence();
        System.out.println(obj.solve(graph, N, M));

        sc.close();
    }

    int solve(String[] graph, int N, int M) {

        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (graph[i].charAt(j) == 'C') {

                    if (dfs(graph, visited, i, j, 0, N, M)) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    boolean dfs(String[] graph, boolean[][] visited,
                int row, int col, int index, int N, int M) {

        if (graph[row].charAt(col) != target.charAt(index))
            return false;

        if (index == target.length() - 1)
            return true;

        visited[row][col] = true;

        for (int k = 0; k < 8; k++) {

            int newRow = row + dx[k];
            int newCol = col + dy[k];

            if (newRow >= 0 && newRow < N &&
                newCol >= 0 && newCol < M &&
                !visited[newRow][newCol]) {

                if (dfs(graph, visited, newRow, newCol, index + 1, N, M)) {
                    return true;
                }
            }
        }

        visited[row][col] = false; // Backtrack
        return false;
    }
}