package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class MaxSumNodePair {
	TreeNode<Integer> node;
	int sum;

	MaxSumNodePair(TreeNode<Integer> node, int sum) {
		this.node = node;
		this.sum = sum;
	}
}

public class MaxNode {

	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
		return maxSumNodeHelper(root).node;
	}
	private static MaxSumNodePair maxSumNodeHelper(TreeNode<Integer> root) {

		if (root == null) {
			return new MaxSumNodePair(null, Integer.MIN_VALUE);
		}

		// Calculate sum of current node + its immediate children
		int currentSum = root.data;

		for (TreeNode<Integer> child : root.children) {
			currentSum += child.data;
		}

		// Assume current node has max sum
		MaxSumNodePair maxPair = new MaxSumNodePair(root, currentSum);

		// Recursively check children
		for (TreeNode<Integer> child : root.children) {
			MaxSumNodePair childPair = maxSumNodeHelper(child);

			if (childPair.sum > maxPair.sum) {
				maxPair = childPair;
			}
		}

		return maxPair;
	}

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
	public static void main(String[] args) {
		TreeNode<Integer>  root=takeInput();
		System.out.println(maxSumNode(root).data);

	}

}
