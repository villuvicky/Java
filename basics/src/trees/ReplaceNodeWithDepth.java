package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReplaceNodeWithDepth {
	
	public static TreeNode<Integer> takeInput(){

		Scanner sc= new Scanner(System.in);
		System.out.println("Enter root value ");
		int rootData= sc.nextInt();
		TreeNode<Integer> root= new TreeNode<>(rootData);
		Queue<TreeNode<Integer>> queue= new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			TreeNode<Integer> currentNode=queue.poll();
			System.out.println("Enter childNode count for current Node "+ currentNode.data );
			int childCount=sc.nextInt();
			for(int i=0;i<childCount;i++) {
				System.out.println("Enter childNode data ");
				int childData=sc.nextInt();
				TreeNode<Integer> childNode= new TreeNode<>(childData);
				currentNode.children.add(childNode);
				queue.add(childNode);
			}
		}
		return root;
	}
	
	public static void replaceWithDepthValue(TreeNode<Integer> root) {
		replaceHelper(root, 0);
	}

	private static void replaceHelper(TreeNode<Integer> root, int depth) {

		if (root == null) return;

		// Replace current node's data with depth
		root.data = depth;

		// Call children with depth + 1
		for (TreeNode<Integer> child : root.children) {
			replaceHelper(child, depth + 1);
		}
	}
	
	
	public static void printLevelWise(TreeNode<Integer> root) {

	    if (root == null) return;

	    Queue<TreeNode<Integer>> queue = new LinkedList<>();
	    queue.add(root);

	    while (!queue.isEmpty()) {

	        int size = queue.size();   // number of nodes in current level

	        for (int i = 0; i < size; i++) {

	            TreeNode<Integer> current = queue.poll();
	            System.out.print(current.data + " ");

	            for (TreeNode<Integer> child : current.children) {
	                queue.add(child);
	            }
	        }

	        System.out.println();  // move to next line after each level
	    }
	}
	public static void main(String[] args) {
		TreeNode<Integer> root=takeInput();
		replaceWithDepthValue(root);
		printLevelWise(root);
		

	}

}
