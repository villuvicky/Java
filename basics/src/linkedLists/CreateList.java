package linkedLists;

public class CreateList {

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

	public static void print(Node<Integer> head) {

		while(head!=null) {
			System.out.println(head.data);
			head = head.next;

		}
	}


	public static void nthData(Node<Integer> head,int n) {
		int count=0;
		while(head!=null) {
			if(n==count) {
				System.out.println(head.data);
				return;}
			head = head.next;
			count++;
		}

	}
	public static Node<Integer> insert(Node<Integer> head, int pos, int data){
		
			Node<Integer> newNode= new Node<>(data);
			Node<Integer> prevNode=head;
			int count =0;
			while(count<pos-1) {
				count++;
				prevNode=prevNode.next;
			}
			prevNode.next=newNode;
			newNode.next=prevNode.next;
			
			return head;
		}
		
		
		
	
	public static void main(String[] args) {

		Node<Integer> head=createListAndNode();
		insert(head, 2, 100);
		print(head);
		//nthData(head, 3);

	}

}
