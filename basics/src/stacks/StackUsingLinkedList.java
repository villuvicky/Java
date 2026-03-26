package stacks;

import linkedLists.Node;

public class StackUsingLinkedList<T> {
	
	private Node<T> head;
	private int size;

	public int getSize() { 
        return size;
    }

    public boolean isEmpty() {
       
    	return 	size==0;
    }

    public void push(T element) {
      
    	Node<T> newNode= new Node<>(element);
    	newNode.next=head;
    	head=newNode;
    	size++;
    }

    public T pop() {
    	if(head!=null) {
    	return head.data;}
    	return null;
    }

    public T top() {
        
    	if(head!=null) {
    	T temp=head.data;
    	head= head.next;
    	size--;
    	return temp;}
    	return null;
    }
}
