package stacks;

public class StackUsingArray {

	private int data[];
	private int topIndex;

	public StackUsingArray() {

		data = new int[10];
		topIndex=-1;//since no element is present, currently it will be -1.
	}

	public int size() {
		return topIndex+1;
	}

	public boolean isEmpty() {

		return topIndex==-1;
	}
	public void push(int ele) throws StackFullException {

		if(topIndex==data.length-1) {
			throw new StackFullException();

		}

		data[++topIndex]=ele;

	}

	public int top() throws StackFullException {
		
		if(topIndex==-1)
			throw new StackFullException();
		return data[topIndex];
	}
	public int pop() throws StackFullException {
		
		if(topIndex==-1)
			throw new StackFullException();
		
		int temp=data[topIndex];
		topIndex--;
		return temp;
	}

}
