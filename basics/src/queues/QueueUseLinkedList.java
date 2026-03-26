package queues;

public class QueueUseLinkedList<T> {


	private Node<T> front;
	private Node<T> rear;
	int size;
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;

	}
	public void enqueue(T ele) {
		Node<T> newNode= new Node<>(ele);
		if(rear==null) {

			front=newNode;
			rear=newNode;
		}
		else {
			rear.next=newNode;
			rear=newNode;
		}
		
		size++;

	}

	public T front() {
		if(front==null)
			return null;
		else
		{
			return front.data;
		}
	}

	public T dequeue() {
		if(front==null)
			return null;
		
		T temp=front.data;
		front=front.next;
		size--;
		if(front==null)
			rear= null;
		return temp;


	}

}
