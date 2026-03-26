package binaryTreeSearch;

public class DiamterOfBinaryTree {
	static int diameter = 0;

	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
	    height(root);
	    return diameter;
	}

	private static int height(BinaryTreeNode<Integer> root) {
	    if (root == null) return 0;

	    int left = height(root.left);
	    int right = height(root.right);

	    diameter = Math.max(diameter, left + right+1);

	    return 1 + Math.max(left, right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
