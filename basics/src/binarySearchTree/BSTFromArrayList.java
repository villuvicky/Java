package binarySearchTree;

import binaryTreeSearch.BinaryTreeNode;

public class BSTFromArrayList {
	
	 public static BinaryTreeNode<Integer> sortedArrayToBST(int[] arr) {
	        return helper(arr, 0, arr.length - 1);
	    }

	    private static BinaryTreeNode<Integer> helper(int[] arr, int start, int end) {

	        if (start > end) return null;

	        int mid = (start + end) / 2;

	        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);

	        root.left = helper(arr, start, mid - 1);
	        root.right = helper(arr, mid + 1, end);

	        return root;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
