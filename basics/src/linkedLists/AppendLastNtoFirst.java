package linkedLists;

import java.util.Scanner;

public class AppendLastNtoFirst {
	
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
	public static Node<Integer> appendLastNToFirst(Node<Integer> head, int N) {

	    // edge cases
	    if (head == null || N == 0) {
	        return head;
	    }

	    // Step 1: find length
	    int length = 0;
	    Node<Integer> temp = head;
	    while (temp != null) {
	        length++;
	        temp = temp.next;
	    }

	    // Step 2: normalize N
	    N = N % length;
	    if (N == 0) {
	        return head;
	    }

	    // Step 3: move to (length - N - 1)th node
	    int splitPoint = length - N;
	    Node<Integer> prev = head;
	    for (int i = 1; i < splitPoint; i++) {
	        prev = prev.next;
	    }

	    // Step 4: rearrange pointers
	    Node<Integer> newHead = prev.next;
	    prev.next = null;

	    Node<Integer> tail = newHead;
	    while (tail.next != null) {
	        tail = tail.next;
	    }

	    tail.next = head;

	    return newHead;
	}
	public static void print(Node<Integer> head) {

		while(head!=null) {
			System.out.println(head.data);
			head = head.next;

		}
	}


	public static void main(String[] args) {
		Node<Integer> head=	takeInput();
		print(appendLastNToFirst(head, 3));
	}

}
