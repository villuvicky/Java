package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LeafNodeCount {

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


	public static int countLeafNodes(TreeNode<Integer> root) {

		if (root == null) return 0;

		// If no children → it's a leaf
		if (root.children.size() == 0) {
			return 1;
		}

		int count = 0;

		for (TreeNode<Integer> child : root.children) {
			count += countLeafNodes(child);
		}

		return count;
	}
	public static void main(String[] args) {
		TreeNode<Integer> root=takeInput();
		System.out.println(countLeafNodes(root));

	}

}
