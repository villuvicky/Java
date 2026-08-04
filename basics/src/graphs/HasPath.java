package graphs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class HasPath {

    public static boolean hasPath(int[][] graph, int current, int destination, boolean[] visited) {

        if (current == destination) {
            return true;
        }

        visited[current] = true;

        for (int i = 0; i < graph.length; i++) {
            if (graph[current][i] == 1 && !visited[i]) {
                if (hasPath(graph, i, destination, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");

        int V = Integer.parseInt(firstLine[0]);
        int E = Integer.parseInt(firstLine[1]);

        int[][] graph = new int[V][V];

        for (int i = 0; i < E; i++) {
            String[] edge = br.readLine().split(" ");

            int v1 = Integer.parseInt(edge[0]);
            int v2 = Integer.parseInt(edge[1]);

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        String[] vertices = br.readLine().split(" ");

        int source = Integer.parseInt(vertices[0]);
        int destination = Integer.parseInt(vertices[1]);

        boolean[] visited = new boolean[V];

        System.out.println(hasPath(graph, source, destination, visited));
    }
}

