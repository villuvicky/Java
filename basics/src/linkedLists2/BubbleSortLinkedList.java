package linkedLists2;

import java.util.Scanner;

public class BubbleSortLinkedList {

	
	public static Node<Integer> bubbleSort(Node<Integer> head) {
	    
	    if (head == null || head.next == null)
	        return head;

	    Node<Integer> end = null;

	    while (end != head) {
	        Node<Integer> current = head;
	        
	        while (current.next != end) {
	            
	            if (current.data > current.next.data) {
	                int temp = current.data;
	                current.data = current.next.data;
	                current.next.data = temp;
	            }
	            
	            current = current.next;
	        }
	        
	        end = current;
	    }
	    
	    return head;
	}

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
	public static void main(String[] args) {
	
		Node<Integer> head1=takeInput();
		
		print(bubbleSort(head1));
	}

}
