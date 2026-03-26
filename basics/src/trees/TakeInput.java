package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TakeInput {



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
	public static void printTree(TreeNode<Integer> root) {
		if(root==null) {
			return;
		}

		System.out.print(root.data+" : ");

		for(int i=0;i<root.children.size();i++) {
			System.out.print(root.children.get(i).data+" ");

		}
		System.out.println();
		for(int i=0;i<root.children.size();i++) {
			TreeNode<Integer> child =root.children.get(i);
			printTree(child);
		}
	}



	public static void printLevelWise(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();   // number of nodes at current level
			for (int i = 0; i < levelSize; i++) {
				TreeNode<Integer> currentNode = queue.poll();
				System.out.print(currentNode.data + " ");

				// Add children of current node
				for (int j = 0; j < currentNode.children.size(); j++) {
					queue.add(currentNode.children.get(j));
				}
			}
			// Move to next line after one level
			System.out.println();
		}
	}
	public static void main(String[] args) {
		TreeNode<Integer>  root=takeInput();
		printTree(root);
		printLevelWise(root);

	}

}
