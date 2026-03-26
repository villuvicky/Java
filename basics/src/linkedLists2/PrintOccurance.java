package linkedLists2;

import java.util.Scanner;

public class PrintOccurance {
	

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
	public static int findNodeRec(Node<Integer> head, int n) {
    	
		//int count=0;
		
		if(head==null) {
			return -1;
		}
		
		if(head.data==n) {
			return 0;
		}
		int ans=findNodeRec(head.next, n);
		if(ans==-1) {
			return -1;
		}
		else {
			return ans+1;
		}
		 
	}

	public static void main(String[] args) {
		
		System.out.println(findNodeRec(takeInput(), 2));

	}

}
