package binarySearchTree;

import binaryTreeSearch.BinaryTreeNode;

public class IsBST {
	public static boolean isBST(BinaryTreeNode<Integer> root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean helper(BinaryTreeNode<Integer> root, int min, int max) {

        if (root == null) return true;

        // Check current node
        if (root.data < min || root.data > max) {
            return false;
        }

        // Check left and right subtrees
        return helper(root.left, min, root.data - 1) &&
               helper(root.right, root.data + 1, max);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
