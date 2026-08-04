package graphs;

import java.util.Scanner;

public class Islands {
	private static void dfs(int[][] edges, int vertex, boolean[] visited, int n) {
        visited[vertex] = true;

        for (int i = 0; i < n; i++) {
            if (edges[vertex][i] == 1 && !visited[i]) {
                dfs(edges, i, visited, n);
            }
        }
    }

    public static int numConnected(int[][] edges, int n) {
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(edges, i, visited, n);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of islands (vertices)
        int e = sc.nextInt(); // Number of connections (edges)

        int[][] edges = new int[n][n];

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            edges[v1][v2] = 1;
            edges[v2][v1] = 1; // Undirected graph
        }

        System.out.println(numConnected(edges, n));

        sc.close();
    }
}
