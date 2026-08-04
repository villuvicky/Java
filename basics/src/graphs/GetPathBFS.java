package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GetPathBFS {
    public static ArrayList<Integer> getPathBFS(int[][] graph, int start, int end) {

        boolean[] visited = new boolean[graph.length];
        HashMap<Integer, Integer> parent = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        boolean found = false;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            if (current == end) {
                found = true;
                break;
            }

            for (int i = 0; i < graph.length; i++) {

                if (graph[current][i] == 1 && !visited[i]) {

                    visited[i] = true;
                    parent.put(i, current);
                    queue.offer(i);

                    if (i == end) {
                        found = true;
                        break;
                    }
                }
            }

            if (found) {
                break;
            }
        }

        if (!found) {
            return null;
        }

        ArrayList<Integer> path = new ArrayList<>();

        int current = end;
        path.add(current);

        while (current != start) {
            current = parent.get(current);
            path.add(current);
        }

        return path;
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

        ArrayList<Integer> path = getPathBFS(graph, start, end);

        if (path != null) {
            for (int vertex : path) {
                System.out.print(vertex + " ");
            }
        }
    }
}