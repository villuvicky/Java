package binarySearchTree;

import java.util.ArrayList;
import java.util.Collections;

import binaryTreeSearch.BinaryTreeNode;

public class PathFromNodeToRoot {
	
	public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int k) {
        ArrayList<Integer> path = new ArrayList<>();

        while (root != null) {
            path.add(root.data);

            if (root.data == k) {
                Collections.reverse(path); // convert root→k to k→root
                return path;
            } else if (k < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        // if not found
        return new ArrayList<>();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
