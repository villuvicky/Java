package binarySearchTree;

import binaryTreeSearch.BinaryTreeNode;

public class LCAinBST {
	public static int LCA(BinaryTreeNode<Integer> root, int n1, int n2) {
        BinaryTreeNode<Integer> lca = findLCA(root, n1, n2);

        if (lca == null) return -1;

        boolean found1 = exists(lca, n1);
        boolean found2 = exists(lca, n2);

        if (found1 && found2) return lca.data;
        if (found1) return n1;
        if (found2) return n2;

        return -1;
    }

    private static BinaryTreeNode<Integer> findLCA(BinaryTreeNode<Integer> root, int n1, int n2) {
        while (root != null) {
            if (n1 < root.data && n2 < root.data) {
                root = root.left;
            } else if (n1 > root.data && n2 > root.data) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    private static boolean exists(BinaryTreeNode<Integer> root, int x) {
        while (root != null) {
            if (root.data == x) return true;
            else if (x < root.data) root = root.left;
            else root = root.right;
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
