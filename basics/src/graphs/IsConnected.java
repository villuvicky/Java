package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsConnected {
	 public static void dfs(int[][] graph, int current, boolean[] visited) {

	        visited[current] = true;

	        for (int i = 0; i < graph.length; i++) {
	            if (graph[current][i] == 1 && !visited[i]) {
	                dfs(graph, i, visited);
	            }
	        }
	    }

	    public static boolean isConnected(int[][] graph) {

	        int n = graph.length;

	        // Empty graph is considered connected
	        if (n == 0) {
	            return true;
	        }

	        boolean[] visited = new boolean[n];

	        dfs(graph, 0, visited);

	        for (boolean vertexVisited : visited) {
	            if (!vertexVisited) {
	                return false;
	            }
	        }

	        return true;
	    }

	    public static void main(String[] args)
	            throws NumberFormatException, IOException {

	        BufferedReader br =
	                new BufferedReader(new InputStreamReader(System.in));

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

	        System.out.println(isConnected(graph));
	    }
}
