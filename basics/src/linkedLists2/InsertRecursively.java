package linkedLists2;

import java.util.Scanner;

public class InsertRecursively {
	
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
	
	public static Node<Integer> insert(Node<Integer> head, int pos, int value){
		
		
		if(head==null&&pos>0) {
			return head;
		}
		if(pos==0) {
			Node<Integer> newNode= new Node<>(value);
			newNode.next= head;
			return newNode;
		}
		else {
			head.next=insert(head.next, pos-1, value);
			return head;
		}
		                                                                                                                                                                       
	}

	public static void main(String[] args) {
		
		printRec(insert(takeInput(), 1, 10));
	}

}
