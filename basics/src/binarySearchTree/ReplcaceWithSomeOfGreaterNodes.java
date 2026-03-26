package binarySearchTree;

import binaryTreeSearch.BinaryTreeNode;

public class ReplcaceWithSomeOfGreaterNodes {
	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
        helper(root, new int[]{0});
    }

    private static void helper(BinaryTreeNode<Integer> root, int[] sum) {
        if (root == null) return;

        // Step 1: go right (greater values)
        helper(root.right, sum);

        // Step 2: process current node
        sum[0] += root.data;
        root.data = sum[0];

        // Step 3: go left
        helper(root.left, sum);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
