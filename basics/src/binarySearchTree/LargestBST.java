package binarySearchTree;

import binaryTreeSearch.BinaryTreeNode;

class Info {
	boolean isBST;
	int height;
	int min;
	int max;

	Info(boolean isBST, int height, int min, int max) {
		this.isBST = isBST;
		this.height = height;
		this.min = min;
		this.max = max;
	}
}
public class LargestBST {
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		return helper(root).height;
	}

	private static Info helper(BinaryTreeNode<Integer> node) {

		// Base case
		if (node == null) {
			return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}

		Info left = helper(node.left);
		Info right = helper(node.right);

		// Check BST condition
		if (left.isBST && right.isBST &&
				node.data > left.max && node.data <= right.min) {

			int height = 1 + Math.max(left.height, right.height);

			int min = Math.min(node.data, left.min);
			int max = Math.max(node.data, right.max);

			return new Info(true, height, min, max);
		}

		// Not a BST → take max height from children
		return new Info(false,
				Math.max(left.height, right.height),
				0, 0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
