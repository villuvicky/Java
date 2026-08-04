package graphs;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class GetPathDFS {
	public static ArrayList<Integer> getPathDFS(int[][] graph, int start,
			int end, boolean[] visited) {
		if (start == end) {
			ArrayList<Integer> path = new ArrayList<>();
			path.add(start);
			return path;
		}
		visited[start] = true;
		for (int i = 0; i < graph.length; i++) {
			if (graph[start][i] == 1 && !visited[i]) {
				ArrayList<Integer> path =
						getPathDFS(graph, i, end, visited);
				if (path != null) {
					path.add(start);
					return path;
				}
			}
		}
		return null;
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
		String[] vertices = br.readLine().split(" ");
		int start = Integer.parseInt(vertices[0]);
		int end = Integer.parseInt(vertices[1]);
		boolean[] visited = new boolean[V];
		ArrayList<Integer> path =
				getPathDFS(graph, start, end, visited);
		if (path != null) {
			for (int vertex : path) {
				System.out.print(vertex + " ");
			}
		}
	}
}
