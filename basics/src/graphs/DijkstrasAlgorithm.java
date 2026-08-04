package graphs;
import java.util.*;
public class DijkstrasAlgorithm {
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

	        dijkstra(graph, V);

	        sc.close();
	    }

	    static void dijkstra(int[][] graph, int V) {

	        boolean[] visited = new boolean[V];
	        int[] distance = new int[V];

	        Arrays.fill(distance, Integer.MAX_VALUE);

	        distance[0] = 0;

	        for (int i = 0; i < V - 1; i++) {

	            int minVertex = findMinVertex(distance, visited);

	            visited[minVertex] = true;

	            for (int j = 0; j < V; j++) {

	                if (graph[minVertex][j] != 0 &&
	                    !visited[j] &&
	                    distance[minVertex] != Integer.MAX_VALUE &&
	                    distance[minVertex] + graph[minVertex][j] < distance[j]) {

	                    distance[j] = distance[minVertex] + graph[minVertex][j];
	                }
	            }
	        }

	        for (int i = 0; i < V; i++) {
	            System.out.println(i + " " + distance[i]);
	        }
	    }

	    static int findMinVertex(int[] distance, boolean[] visited) {

	        int minVertex = -1;

	        for (int i = 0; i < distance.length; i++) {

	            if (!visited[i] &&
	                (minVertex == -1 || distance[i] < distance[minVertex])) {

	                minVertex = i;
	            }
	        }

	        return minVertex;
	    }
}
