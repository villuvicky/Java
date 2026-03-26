package linkedLists2;

import java.util.Scanner;



public class PrintRecursively {

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

	public static void printRec(Node<Integer> head) {

		if(head==null)
			return;
		System.out.println(head.data);
		printRec(head.next);
	}
	public static void printRecReverse(Node<Integer> head) {

		if(head==null)
			return;
		printRec(head.next);
		System.out.println(head.data);
	}


	public static int count(Node<Integer> head) {

		if(head==null)
			return 0;
		return 1+count(head.next);

	}
	public static Node<Integer> reverse(Node<Integer> head) {

	    Node<Integer> prev = null;
	    Node<Integer> curr = head;

	    while (curr != null) {
	        Node<Integer> next = curr.next;  // store next node
	        curr.next = prev;               // reverse pointer
	        prev = curr;                    // move prev forward
	        curr = next;                    // move curr forward
	    }

	    return prev;   // new head
	}
	public static void main(String[] args) {

		Node<Integer>	head=   takeInput();
		printRec(head);
		printRecReverse(head);
		System.out.println(count(head));

	}

}
