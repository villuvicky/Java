package linkedLists2;

import java.util.Scanner;

public class SkipMDeleteNClass {
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
	public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
		if(head==null) {
			return null;
		}

		if(M==0) {
			return null;
		}

		Node<Integer> currentNode=head;

		while(currentNode!=null) {

			for (int i = 1; i < M && currentNode != null; i++) {
				currentNode = currentNode.next;
			}

			if (currentNode == null) {
				return head;
			}
			
			Node<Integer> temp=currentNode.next;
			
			for(int i=0;i<N&&temp != null; i++) {
				temp=temp.next;
			}
			currentNode.next=temp;
			currentNode=temp;
		}
		return head;
	}
	public static void print(Node<Integer> head) {

		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	public static void main(String[] args) {

		Node<Integer> head=takeInput();
		Node<Integer> sorted =skipMdeleteN(head,2,2);
		print(sorted);

	}

}
