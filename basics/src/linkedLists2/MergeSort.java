package linkedLists2;

import java.util.Scanner;

public class MergeSort {
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

	public static Node<Integer> mergeSort(Node<Integer> head) {

		if(head==null)
			return head;

		if(head.next==null)
			return head;

		Node<Integer> slow=head;
		Node<Integer> fast=head;

		while(fast.next!=null&&fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		Node<Integer> head1=head;
		Node<Integer> head2=slow.next;

		slow.next=null;
		head1 = mergeSort(head1);
		head2 = mergeSort(head2);

		return twoSortedMerge(head1, head2);

	}


	public static Node<Integer> twoSortedMerge(Node<Integer> head1, Node<Integer> head2){
		Node<Integer>fHead=null;
		Node<Integer>tail=null;
		if(head1.data<=head2.data) {
			fHead=head1;
			tail=head1;
			head1=head1.next;
		}
		else {

			fHead=head2;
			tail=head2;
			head2=head2.next;
		}

		while(head1!=null&&head2!=null) {

			if(head1.data<=head2.data) {
				tail.next=head1;
				tail=head1;
				head1=head1.next;
			}
			else {
				tail.next=head2;
				tail=head2;
				head2=head2.next;
			}
		}
		if(head1!=null)
			tail.next=head1;
		else
			tail.next=head2;

		return fHead;
	}

	public static void print(Node<Integer> head) {

		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	public static void main(String[] args) {

		Node<Integer> head=takeInput();
		Node<Integer> sortedHead=mergeSort(head);
		print(sortedHead);

	}

}
