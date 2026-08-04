package graphs;
import java.util.*;
public class KruskalsAlgorithm {



	    static class Edge implements Comparable<Edge> {
	        int src;
	        int dest;
	        int weight;

	        Edge(int src, int dest, int weight) {
	            this.src = src;
	            this.dest = dest;
	            this.weight = weight;
	        }

	        public int compareTo(Edge e) {
	            return this.weight - e.weight;
	        }
	    }

	    static int findParent(int v, int[] parent) {
	        if (parent[v] == v)
	            return v;

	        return findParent(parent[v], parent);
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        int V = sc.nextInt();
	        int E = sc.nextInt();

	        Edge[] edges = new Edge[E];

	        for (int i = 0; i < E; i++) {
	            int src = sc.nextInt();
	            int dest = sc.nextInt();
	            int weight = sc.nextInt();

	            edges[i] = new Edge(src, dest, weight);
	        }

	        Arrays.sort(edges);

	        int[] parent = new int[V];

	        for (int i = 0; i < V; i++) {
	            parent[i] = i;
	        }

	        int count = 0;
	        int i = 0;

	        while (count < V - 1) {

	            Edge current = edges[i];

	            int srcParent = findParent(current.src, parent);
	            int destParent = findParent(current.dest, parent);

	            if (srcParent != destParent) {

	                if (current.src < current.dest)
	                    System.out.println(current.src + " " + current.dest + " " + current.weight);
	                else
	                    System.out.println(current.dest + " " + current.src + " " + current.weight);

	                parent[srcParent] = destParent;
	                count++;
	            }

	            i++;
	        }

	        sc.close();
	    }
	}

