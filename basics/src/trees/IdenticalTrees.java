package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IdenticalTrees {
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

	public static boolean identicalTree(TreeNode<Integer> root1, TreeNode<Integer> root2) {

		if(root1==null&& root2==null) {
			return true;
		}
		if(root1==null|| root2==null) {
			return false;
		}
		if (!root1.data.equals(root2.data)) {
			return false;
		}
		if (root1.children.size() != root2.children.size()) {
			return false;
		}
		// Case 5: recursively check children
		for (int i = 0; i < root1.children.size(); i++) {

			boolean childEqual = identicalTree(
					root1.children.get(i),
					root2.children.get(i)
					);
			if (!childEqual) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		TreeNode<Integer> tree1=takeInput();
		TreeNode<Integer> tree2=takeInput();
		System.out.println(identicalTree(tree1, tree2));
	}

}
