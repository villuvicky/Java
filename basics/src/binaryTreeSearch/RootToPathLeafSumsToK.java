package binaryTreeSearch;

import java.util.ArrayList;
import java.util.List;

public class RootToPathLeafSumsToK {
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        List<Integer> path = new ArrayList<>();
        helper(root, k, path);
    }

    private static void helper(BinaryTreeNode<Integer> root, int k, List<Integer> path) {

        if (root == null) return;

        // Add current node to path
        path.add(root.data);

        // Check if leaf node
        if (root.left == null && root.right == null) {

            if (k == root.data) {
                // Print path
                for (int val : path) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            // Backtrack
            path.remove(path.size() - 1);
            return;
        }

        // Recurse left & right
        helper(root.left, k - root.data, path);
        helper(root.right, k - root.data, path);

        // Backtrack
        path.remove(path.size() - 1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
