package linkedLists2;

import java.util.Scanner;

public class MidOfLinkedList {
	
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
	
	public static Node<Integer> mid(Node<Integer> head){
		
		Node<Integer> slow=head;
		Node<Integer> fast= head;
		
		if(head==null)
			return head;
		
		if(head.next==null)
			return head;
		
		while(fast.next!=null&&fast.next.next!=null) {
			slow= slow.next;
			fast=fast.next.next;
		}
		return slow;
		
	}

	public static void main(String[] args) {
		
		System.out.println(mid(takeInput()).data);

	}

}
