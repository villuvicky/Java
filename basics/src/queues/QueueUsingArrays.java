package queues;

public class QueueUsingArrays {

	private int data[];
	private int front;
	private int rear;
	private int size;
	public QueueUsingArrays() {

		data= new int[5];
		front=-1;
		rear=-1;
	}
	public QueueUsingArrays(int capacity) {

		data= new int[capacity];
		front=-1;
		rear=-1;
	}

	public int size() {
		return size;
	}

	public void enqueue(int ele) {
		
		if(size==data.length)
			doubleCapacity();
		
		if(size==0)
			front=0;
		
		rear++;
		data[rear]=ele;
		size++;

	}

	private void doubleCapacity() {
		int temp[]=data;
		data= new int[2*temp.length];
		
		int index=0;
		
		for(int i=front; i<temp.length;i++) {
			data[index++]=temp[i];
		}
		
	}
	public int dequeue() {
		
		if(size==0)
			return -1;
		
		int temp=data[front];
		front++;
		size--;
		if(size==0) {
			front =-1;
			rear=-1;
		}
		return temp;
		
		
	}
	
	public int front() {

		if(size==0)
			return -1;

		return data[front];
	}
	public int rear() {

		return data[rear];
	}
}
