package linkedLists2;

import java.util.Scanner;

import linkedLists2.Node;

public class DeleteNode {

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
	public static Node<Integer> deleteNodeRec(Node<Integer> head, int pos) {
		
		if(head==null)
		{
			return head;	
		}
		if(pos==0)
		{
			return head.next;
		}
		head.next=deleteNodeRec(head.next, pos-1);
			return head;
		}
	public static void main(String[] args) {
		Node<Integer> head=takeInput();
		Node<Integer> head2=deleteNodeRec(head, 1);
		print(head2);

	}

}
