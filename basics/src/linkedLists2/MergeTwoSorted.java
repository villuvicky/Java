package linkedLists2;

import java.util.Scanner;



public class MergeTwoSorted {
	

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

	public static Node<Integer> mergeTwoSorteds(Node<Integer> head1, Node<Integer> head2) {
		Node<Integer> t1=head1;
		Node<Integer> t2=head2;
		Node<Integer> head=null;
		Node<Integer> tail=null;
		
		if(head1==null)
			return head2;
		if(head2==null)
			return head1;
		
		if(t1.data<=t2.data) {
			head=t1;
			tail=t1;
			t1=t1.next;
		}
		else {
			head=t2;
			tail=t2;
			t2=t2.next;
		}
		
		while(t1!=null&&t2!=null) {
			
			if(t1.data<=t2.data) {
				tail.next=t1;
				tail=t1;
				t1=t1.next;
			}
			else {
				
				tail.next=t2;
				tail=t2;
				t2=t2.next;
			}
		}
		if(t1!=null)
			tail.next=t1;
		else
			tail.next=t2;
		
		return head;
		
		
    }
	public static void print(Node<Integer> head) {

		while(head!=null) {
			System.out.println(head.data);
			head = head.next;

		}
	}
	public static void main(String[] args) {
		
		Node<Integer> head1=takeInput();
		Node<Integer> head2=takeInput();
		Node<Integer> head=mergeTwoSorteds(head1, head2);
		print(head);

	}

}
