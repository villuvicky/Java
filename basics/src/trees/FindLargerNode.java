package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindLargerNode {
	
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

	static TreeNode<Integer> nextLarger;

	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {
	    nextLarger = null;
	    helper(root, n);
	    return nextLarger;
	}
	private static void helper(TreeNode<Integer> root, int n) {
	    if (root == null) {
	        return;
	    }
	    // Check if current node is valid candidate
	    if (root.data > n) {

	        if (nextLarger == null || root.data < nextLarger.data) {
	            nextLarger = root;
	        }
	    }
	    // Recur for children
	    for (TreeNode<Integer> child : root.children) {
	        helper(child, n);
	    }
	}
	public static void main(String[] args) {
		TreeNode<Integer> root=takeInput();
		System.out.println(findNextLargerNode(root, 5).data);
	}

}
