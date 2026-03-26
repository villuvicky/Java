package linkedLists;

import java.util.Scanner;

public class InputMethods {

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

	public static Node<Integer> insert(Node<Integer> head, int pos, int data){

		Node<Integer> newNode= new Node<>(data);
		if(pos==0) {
			newNode.next=head;
			head=newNode;
			return newNode;
		}
		else {
			int count =0;	
			Node<Integer> prevNode=head;
			while(count<pos-1&&prevNode!=null) {
				count++;
				prevNode=prevNode.next;
			}
			if(prevNode!=null) {
				newNode.next=prevNode.next;
				prevNode.next=newNode;
			}
			return head;
		}
	}
	public static void main(String[] args) {
		Node<Integer> head=takeInput();
		Node<Integer> head2=insert(head, 0, 100);
		print(head2);
	}

}
