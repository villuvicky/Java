package linkedLists2;

import java.util.Scanner;

public class ArrangeOddEven {

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
	public static Node<Integer> evenAfterOdd(Node<Integer> head) {

		if(head==null) {
			return head;
		}
		Node<Integer> oddHead = null, oddTail=null, evenHead=null, evenTail=null;
		Node<Integer> current=head;
		while(current!=null) {
			Node<Integer> nextNode=current.next;
			current.next=null;
			if(current.data%2!=0) {
				if(oddHead==null) {
					oddHead=current;
					oddTail=current;
				}
				else {
					oddTail.next = current;
					oddTail = current;
				}
			}
			else {
				if(evenHead==null) {
					evenHead=current;
					evenTail=current;
				}
				else {
					evenTail.next=current;
					evenTail=current;
				}
			}
			current=nextNode;
		}

		if(oddHead==null) {
			return evenHead;
		}
		oddTail.next=evenHead;
		if (evenTail != null) {
			evenTail.next = null;
		}
		return oddHead;
	}
	
	public static void print(Node<Integer> head) {

		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	public static void main(String[] args) {
		Node<Integer> head=takeInput();
		Node<Integer> sorted =evenAfterOdd(head);
		print(sorted);
		

	}

}
