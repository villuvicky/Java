package binarySearchTree;

import binaryTreeSearch.BinaryTreeNode;

public class BST {

	private BinaryTreeNode<Integer> root;
	private int size;

	public boolean isPresent(int x) {
		return isPresentHelper(root, x);
	}

	private static boolean isPresentHelper(BinaryTreeNode<Integer> node, int x) {
		if(node==null) {
			return false;
		}
		if(node.data==x) {
			return true;
		}
		if(node.data<x) {
			return isPresentHelper(node.left, x);
		}
		else {
			return isPresentHelper(node.right, x);
		}
	}

	public void insert(int data) {
		root=insertHelper(root, data);
		size++;
	}
	private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> node,int x) {
		if (node == null) {
	        return new BinaryTreeNode<>(x);
	    }

	    if  (x <= node.data) {  
	        node.left = insertHelper(node.left, x);
	    } else {
	        node.right = insertHelper(node.right, x);
	    }

	    return node;
	}
	public void delete(int data) {
		root = delete(root, data);
	}

	private BinaryTreeNode<Integer>  delete(BinaryTreeNode<Integer>  node, int data) {
		if (node == null) return null;

		if (data < node.data) {
			node.left = delete(node.left, data);
		} else if (data > node.data) {
			node.right = delete(node.right, data);
		} else {
			// Node found

			// Case 1: No child
			if (node.left == null && node.right == null) {
				return null;
			}

			// Case 2: One child
			if (node.left == null) {
				return node.right;
			}
			if (node.right == null) {
				return node.left;
			}

			// Case 3: Two children
			int minRight = findMin(node.right);
			node.data = minRight;
			node.right = delete(node.right, minRight);
		}

		return node;
	}

	private int findMin(BinaryTreeNode<Integer>  node) {
		while (node.left != null) {
			node = node.left;
		}
		return node.data;
	}
	public int size() {
		return size;
	}
	public void printTree() {
		printTreeHelper(root);
	}
	private static void printTreeHelper(BinaryTreeNode<Integer> root) {
		if (root == null) return;

	    System.out.print(root.data + ":");

	    if (root.left != null) {
	        // print left
	        System.out.print("L:" + root.left.data + ",");

	        // print right if exists
	        if (root.right != null) {
	            System.out.print("R:" + root.right.data);
	        }
	    } 
	    else if (root.right != null) {
	        // only right child
	        System.out.print("R:" + root.right.data);
	    }

	    System.out.println();

	    printTreeHelper(root.left);
	    printTreeHelper(root.right);
	}
}
