package linkedLists2;

public class Node <T>{

	T data; // this one will have the value of linked list
	public Node<T> next; // this will hold the address of next value, it will be null for last value.
	
	public Node(T data) {
		this.data=data;
		this.next=null;
	}

}
