package binarySearchTree;

import binaryTreeSearch.BinaryTreeNode;

public class FindNode {
	
	 public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {

	        while (root != null) {

	            if (root.data == k) {
	                return true;
	            } 
	            else if (k < root.data) {
	                root = root.left;
	            } 
	            else {
	                root = root.right;
	            }
	        }

	        return false;
	    }
	 public static boolean searchInBSTRec(BinaryTreeNode<Integer> root, int k) {

		    if (root == null) return false;

		    if (root.data == k) return true;

		    if (k < root.data) {
		        return searchInBSTRec(root.left, k);
		    } else {
		        return searchInBSTRec(root.right, k);
		    }
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
