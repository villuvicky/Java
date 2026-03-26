package binaryTreeSearch;

public class NodesAtDistanceK { 
	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int target, int k) {
	helper(root, target, k);
}

private static int helper(BinaryTreeNode<Integer> root, int target, int k) {

	if (root == null) return -1;

	// Target found
	if (root.data == target) {
		printDown(root, k);
		return 0;
	}

	// Search left
	int leftDist = helper(root.left, target, k);
	if (leftDist != -1) {

		if (leftDist + 1 == k) {
			System.out.println(root.data);
		} else {
			printDown(root.right, k - leftDist - 2);
		}

		return leftDist + 1;
	}

	// Search right
	int rightDist = helper(root.right, target, k);
	if (rightDist != -1) {

		if (rightDist + 1 == k) {
			System.out.println(root.data);
		} else {
			printDown(root.left, k - rightDist - 2);
		}

		return rightDist + 1;
	}

	return -1;
}

// Print nodes downward at distance k
private static void printDown(BinaryTreeNode<Integer> root, int k) {

	if (root == null || k < 0) return;

	if (k == 0) {
		System.out.println(root.data);
		return;
	}

	printDown(root.left, k - 1);
	printDown(root.right, k - 1);
}
public static void main(String[] args) {
	// TODO Auto-generated method stub

}

}
