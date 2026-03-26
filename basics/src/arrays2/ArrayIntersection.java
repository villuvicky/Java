package arrays2;

import java.util.Arrays;

public class ArrayIntersection {

	public static void intersection(int[] a, int[] b) {
	    Arrays.sort(a);
	    Arrays.sort(b);

	    int i = 0, j = 0;

	    while (i < a.length && j < b.length) {
	        if (a[i] == b[j]) {
	            System.out.print(a[i] + " ");
	            i++;
	            j++;
	        } else if (a[i] < b[j]) {
	            i++;
	        } else {
	            j++;
	        }
	    }
	}
	public static void bruteForce(int[] a, int[] b) {
	    boolean[] visited = new boolean[b.length];

	    for (int i = 0; i < a.length; i++) {
	        for (int j = 0; j < b.length; j++) {
	            if (a[i] == b[j] && !visited[j]) {
	                System.out.print(a[i] + " ");
	                visited[j] = true;
	                break;
	            }
	        }
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1, 2, 2, 3, 4};
			int []	 B = {2, 2, 4, 6};
			
		//	bruteForce(A, B);
			System.out.println();
			intersection(A, B);
	}

}
