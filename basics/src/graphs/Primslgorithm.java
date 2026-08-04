package graphs;
import java.util.*;
public class Primslgorithm {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] graph = new int[V][V];

        for (int i = 0; i < E; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();

            graph[src][dest] = weight;
            graph[dest][src] = weight;
        }

        prims(graph, V);

        sc.close();
    }

    static void prims(int[][] graph, int V) {

        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        int[] weight = new int[V];

        Arrays.fill(weight, Integer.MAX_VALUE);

        parent[0] = -1;
        weight[0] = 0;

        for (int i = 0; i < V - 1; i++) {

            int minVertex = findMinVertex(weight, visited);

            visited[minVertex] = true;

            for (int j = 0; j < V; j++) {

                if (graph[minVertex][j] != 0 &&
                    !visited[j] &&
                    graph[minVertex][j] < weight[j]) {

                    weight[j] = graph[minVertex][j];
                    parent[j] = minVertex;
                }
            }
        }

        for (int i = 1; i < V; i++) {

            if (parent[i] < i)
                System.out.println(parent[i] + " " + i + " " + weight[i]);
            else
                System.out.println(i + " " + parent[i] + " " + weight[i]);
        }
    }

    static int findMinVertex(int[] weight, boolean[] visited) {

        int minVertex = -1;

        for (int i = 0; i < weight.length; i++) {

            if (!visited[i] &&
                (minVertex == -1 || weight[i] < weight[minVertex])) {

                minVertex = i;
            }
        }

        return minVertex;
    }
}
