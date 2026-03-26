package binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import binaryTreeSearch.BinaryTreeNode;

public class LevelWiseLinkedList {
	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root) {

		ArrayList<LinkedListNode<Integer>> result = new ArrayList<>();

		if (root == null) return result;

		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			int size = queue.size();

			LinkedListNode<Integer> head = null;
			LinkedListNode<Integer> tail = null;

			for (int i = 0; i < size; i++) {
				BinaryTreeNode<Integer> current = queue.poll();

				// create new linked list node
				LinkedListNode<Integer> newNode = new LinkedListNode<>(current.data);

				if (head == null) {
					head = newNode;
					tail = newNode;
				} else {
					tail.next = newNode;
					tail = newNode;
				}

				// add children to queue
				if (current.left != null) queue.add(current.left);
				if (current.right != null) queue.add(current.right);
			}

			result.add(head);
		}

		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
