package linkedLists;

import java.util.Scanner;

public class FindNodeInList {

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

	public static int findNode(Node<Integer> head, int n) {

		int count =0;		
		while(head!=null) {
			
			if(head.data==n) {
				return count;}
			count++;
			head=head.next;
		}
		return -1;


	}

	public static void main(String[] args) {

		Node<Integer> head=	takeInput();
		System.out.println(findNode(head, 5));
	}

}
