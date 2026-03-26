package binarySearchTree;

import java.util.Stack;

import binaryTreeSearch.BinaryTreeNode;

public class PairSumInBST {
	public static void printNodesSumToS(BinaryTreeNode<Integer> root, int S) {

        if (root == null) return;

        Stack<BinaryTreeNode<Integer>> s1 = new Stack<>();
        Stack<BinaryTreeNode<Integer>> s2 = new Stack<>();

        pushLeft(root, s1);
        pushRight(root, s2);

        BinaryTreeNode<Integer> leftNode = getNextLeft(s1);
        BinaryTreeNode<Integer> rightNode = getNextRight(s2);

        while (leftNode != null && rightNode != null &&
               leftNode.data < rightNode.data) {

            int sum = leftNode.data + rightNode.data;

            if (sum == S) {
                System.out.println(leftNode.data + " " + rightNode.data);

                leftNode = getNextLeft(s1);
                rightNode = getNextRight(s2);

            } else if (sum < S) {
                leftNode = getNextLeft(s1);
            } else {
                rightNode = getNextRight(s2);
            }
        }
    }

    // ========= Helpers =========

    private static void pushLeft(BinaryTreeNode<Integer> node, Stack<BinaryTreeNode<Integer>> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    private static void pushRight(BinaryTreeNode<Integer> node, Stack<BinaryTreeNode<Integer>> stack) {
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
    }

    private static BinaryTreeNode<Integer> getNextLeft(Stack<BinaryTreeNode<Integer>> stack) {
        if (stack.isEmpty()) return null;

        BinaryTreeNode<Integer> node = stack.pop();
        pushLeft(node.right, stack);
        return node;
    }

    private static BinaryTreeNode<Integer> getNextRight(Stack<BinaryTreeNode<Integer>> stack) {
        if (stack.isEmpty()) return null;

        BinaryTreeNode<Integer> node = stack.pop();
        pushRight(node.left, stack);
        return node;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
