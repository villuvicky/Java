package graphs;


	import java.util.LinkedList;
	import java.util.Queue;
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.io.IOException;
	import java.util.StringTokenizer;

	public class BFSTravel {

	    public static void printBFS(int[][] graph, int n) {
	        boolean[] visited = new boolean[n];

	        for (int i = 0; i < n; i++) {
	            if (!visited[i]) {
	                bfs(graph, n, i, visited);
	            }
	        }
	    }

	    private static void bfs(int[][] graph, int n, int start, boolean[] visited) {
	        Queue<Integer> queue = new LinkedList<>();

	        queue.offer(start);
	        visited[start] = true;

	        while (!queue.isEmpty()) {
	            int current = queue.poll();
	            System.out.print(current + " ");

	            for (int i = 0; i < n; i++) {
	                if (graph[current][i] == 1 && !visited[i]) {
	                    queue.offer(i);
	                    visited[i] = true;
	                }
	            }
	        }
	    }

	    public static void main(String[] args) throws NumberFormatException, IOException {

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        StringTokenizer st = new StringTokenizer(br.readLine());

	        int V = Integer.parseInt(st.nextToken());
	        int E = Integer.parseInt(st.nextToken());

	        int[][] graph = new int[V][V];

	        for (int i = 0; i < E; i++) {
	            st = new StringTokenizer(br.readLine());

	            int v1 = Integer.parseInt(st.nextToken());
	            int v2 = Integer.parseInt(st.nextToken());

	            graph[v1][v2] = 1;
	            graph[v2][v1] = 1;
	        }

	        printBFS(graph, V);
	    }
	}

