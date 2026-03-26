package linkedLists;

import java.util.Scanner;

public class PalindromeOfLinkedList {
	
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
	public static boolean isPalindrome(Node<Integer> head) {

	    if (head == null || head.next == null) {
	        return true;
	    }

	    // Step 1: Find middle
	    Node<Integer> slow = head;
	    Node<Integer> fast = head;

	    while (fast.next != null && fast.next.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }

	    // Step 2: Reverse second half
	    Node<Integer> secondHalf = reverse(slow.next);

	    // Step 3: Compare both halves
	    Node<Integer> firstHalf = head;
	    Node<Integer> tempSecond = secondHalf;

	    while (tempSecond != null) {
	        if (!firstHalf.data.equals(tempSecond.data)) {
	            return false;
	        }
	        firstHalf = firstHalf.next;
	        tempSecond = tempSecond.next;
	    }

	    return true;
	}
	private static Node<Integer> reverse(Node<Integer> head) {

	    Node<Integer> prev = null;
	    Node<Integer> current = head;

	    while (current != null) {
	        Node<Integer> nextNode = current.next;
	        current.next = prev;
	        prev = current;
	        current = nextNode;
	    }

	    return prev;
	}

	public static void main(String[] args) {
		Node<Integer> head=takeInput();

		
	}

}
