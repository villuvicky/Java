package linkedLists;

import java.util.Scanner;

public class DeleteNodeInList {
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
	public static Node<Integer> delete(Node<Integer> head, int pos){
		if(pos==0) {
			return head.next;
		}
		else {
			int count =0;	
			Node<Integer> prevNode=head;
			while(count<pos-1&&prevNode!=null) {
				count++;
				prevNode=prevNode.next;
			}
			if(prevNode!=null&&prevNode.next!=null) {
				prevNode.next=prevNode.next.next;
			}
			return head;
		}
	}
	
	public static void main(String[] args) {
		Node<Integer> head=takeInput();

		Node<Integer> head2=delete(head, 6);
		print(head2);
	}

}
