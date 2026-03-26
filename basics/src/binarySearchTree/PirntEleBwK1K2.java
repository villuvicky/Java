package binarySearchTree;

import binaryTreeSearch.BinaryTreeNode;

public class PirntEleBwK1K2 {
	public static void printRange(BinaryTreeNode<Integer> root, int k1, int k2) {

        if (root == null) return;

        // If root.data > k1 → left subtree may have valid nodes
        if (root.data > k1) {
            printRange(root.left, k1, k2);
        }

        // If root is in range → print it
        if (root.data >= k1 && root.data <= k2) {
            System.out.print(root.data + " ");
        }

        // If root.data < k2 → right subtree may have valid nodes
        if (root.data < k2) {
            printRange(root.right, k1, k2);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
