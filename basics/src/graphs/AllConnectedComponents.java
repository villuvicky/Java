package graphs;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class AllConnectedComponents {
	public static ArrayList<ArrayList<Integer>> getConnectedComponents(int[][] graph) {

        int n = graph.length;
        boolean[] visited = new boolean[n];

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                ArrayList<Integer> component = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();

                queue.offer(i);
                visited[i] = true;

                while (!queue.isEmpty()) {

                    int current = queue.poll();
                    component.add(current);

                    for (int j = 0; j < n; j++) {

                        if (graph[current][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                }

                Collections.sort(component);
                result.add(component);
            }
        }

        return result;
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

        ArrayList<ArrayList<Integer>> components =
                getConnectedComponents(graph);

        for (ArrayList<Integer> component : components) {

            for (int vertex : component) {
                System.out.print(vertex + " ");
            }

            System.out.println();
        }
    }
}
