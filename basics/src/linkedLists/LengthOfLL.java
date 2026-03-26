package linkedLists;

public class LengthOfLL {

	public static Node<Integer> createListAndNode() {

		Node<Integer> node1= new Node<Integer>(10);
		Node<Integer> node2= new Node<Integer>(20);
		Node<Integer> node3= new Node<Integer>(30);
		Node<Integer> node4= new Node<Integer>(40);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		return node1;
	}


	public static int length(Node<Integer> head){
		int count = 0;
		Node<Integer> current = head;

		while (current != null) {
			
			current = current.next;
			count++;
		}

		return count;
	}
	public static void main(String[] args) {

		Node<Integer> head=createListAndNode();
		System.out.println(length(head));
		
	}

}
