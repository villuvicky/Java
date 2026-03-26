package binaryTreeSearch;

import java.util.HashMap;

public class PreInOrder {

	public static BinaryTreeNode<Integer> buildTree(int[] preorder, int[] inorder) {
		// Map to store inorder index for quick lookup
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return build(preorder, 0, preorder.length - 1,inorder, 0, inorder.length - 1,map);
	}

	private static BinaryTreeNode<Integer> build(int[] preorder, int preStart, int preEnd,int[] inorder, int inStart, int inEnd,HashMap<Integer, Integer> map) {
		// Base case
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		// Step 1: Root from preorder
		int rootData = preorder[preStart];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		// Step 2: Find root in inorder
		int rootIndex = map.get(rootData);
		// Step 3: Count left subtree nodes
		int leftSize = rootIndex - inStart;
		// Step 4: Build left subtree
		root.left = build(preorder,preStart + 1,preStart + leftSize,inorder,inStart,rootIndex - 1,map);
		// Step 5: Build right subtree
		root.right = build(preorder,preStart + leftSize + 1,preEnd,inorder,rootIndex + 1,inEnd,map);
		return root;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
