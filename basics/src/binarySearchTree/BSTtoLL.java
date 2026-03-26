package binarySearchTree;

import binaryTreeSearch.BinaryTreeNode;

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
		this.next = null;
	}
}
class Pair {
	LinkedListNode<Integer> head;
	LinkedListNode<Integer> tail;

	Pair(LinkedListNode<Integer> head, LinkedListNode<Integer> tail) {
		this.head = head;
		this.tail = tail;
	}
}
public class BSTtoLL {
	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
		return helper(root).head;
	}

	private static Pair helper(BinaryTreeNode<Integer> root) {

		if (root == null) {
			return new Pair(null, null);
		}

		// Left subtree
		Pair left = helper(root.left);

		// Current node
		LinkedListNode<Integer> current = new LinkedListNode<>(root.data);

		// Right subtree
		Pair right = helper(root.right);

		// Connect left → current
		if (left.tail != null) {
			left.tail.next = current;
		}

		// Connect current → right
		current.next = right.head;

		// New head
		LinkedListNode<Integer> head = (left.head != null) ? left.head : current;

		// New tail
		LinkedListNode<Integer> tail = (right.tail != null) ? right.tail : current;

		return new Pair(head, tail);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
