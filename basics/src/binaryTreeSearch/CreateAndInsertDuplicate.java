package binaryTreeSearch;

public class CreateAndInsertDuplicate {
	public static void duplicateNodes(BinaryTreeNode<Integer> root) {
        if (root == null) return;

        // Step 1: Duplicate node
        BinaryTreeNode<Integer> duplicate = new BinaryTreeNode<>(root.data);

        // Step 2: Store original left
        BinaryTreeNode<Integer> originalLeft = root.left;

        // Step 3: Insert duplicate
        root.left = duplicate;

        // Step 4: Attach original left to duplicate
        duplicate.left = originalLeft;

        // Step 5: Recur for left subtree (skip duplicate)
        duplicateNodes(originalLeft);

        // Step 6: Recur for right subtree
        duplicateNodes(root.right);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
