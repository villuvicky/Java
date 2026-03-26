package binaryTreeSearch;

import java.util.HashMap;

public class PostInOrder {
    public static BinaryTreeNode<Integer> buildTree(int[] postorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, 0, postorder.length - 1,inorder, 0, inorder.length - 1,map);
    }

    private static BinaryTreeNode<Integer> build(int[] postorder, int postStart, int postEnd,int[] inorder, int inStart, int inEnd,HashMap<Integer, Integer> map) {
        // Base case
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        // Step 1: Root from postorder (LAST element)
        int rootData = postorder[postEnd];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        // Step 2: Find root in inorder
        int rootIndex = map.get(rootData);
        // Step 3: Left subtree size
        int leftSize = rootIndex - inStart;
        // Step 4: Build LEFT subtree
        root.left = build(postorder,postStart,postStart + leftSize - 1,inorder,inStart,rootIndex - 1,map);
        // Step 5: Build RIGHT subtree
        root.right = build(postorder,postStart + leftSize,postEnd - 1,inorder,rootIndex + 1,inEnd,map);
        return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
