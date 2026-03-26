package linkedLists;

import java.util.Scanner;

public class EliminateDuplicates {

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

	public static Node<Integer> removeDuplicates(Node<Integer> head) {
		if (head == null) {
	        return head;
	    }
		Node<Integer> currentNode= head;
		while(currentNode.next!=null) {
			if(currentNode.data.equals(currentNode.next.data)) {
				
				currentNode.next = currentNode.next.next;
			}
			else {
				
				currentNode=currentNode.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {

		print(removeDuplicates(takeInput()));

	}

}
