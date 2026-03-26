package linkedLists;

import java.util.Scanner;

public class PrintReverse {

	public static Node<Integer> takeInput() {
		Scanner sc= new Scanner(System.in);
		int data =sc.nextInt();

		Node<Integer> head=null, tail=null;
		while(data!=-1) {
			Node<Integer> currentNode= new Node<>(data);
			if(head==null) {
				head=currentNode;
				tail=currentNode;}
			else
			{
				tail.next=currentNode;
				tail=tail.next;
			}
			data=sc.nextInt();
		}
		return head;
	}
	public static void print(Node<Integer> head) {

		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	public static Node<Integer> reverse(Node<Integer> head) {

		Node<Integer> prev = null;
		Node<Integer> current = head;

		while (current != null) {
			Node<Integer> nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}

		return prev;
	}
	public static void reverse2(Node<Integer> head) {
		if (head == null) {
			return;
		}

		reverse2(head.next);
		System.out.print(head.data + " ");
		
	}
	
	public static Node<Integer> reverseNode(Node<Integer> head) {

	    // Base case
	    if (head == null || head.next == null) {
	        return head;
	    }

	    // Reverse rest of the list
	    Node<Integer> newHead = reverse(head.next);

	    // Make next node point to current node
	    head.next.next = head;

	    // Break the old link
	    head.next = null;	

	    return newHead;
	}

	public static void main(String[] args) {
		print(reverse(takeInput()));
	}

}
