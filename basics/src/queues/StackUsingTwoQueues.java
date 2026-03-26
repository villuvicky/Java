package queues;

import java.util.LinkedList;
import java.util.Queue;


public class StackUsingTwoQueues  {

	Queue <Integer> s1;
	Queue<Integer>  s2;


	public StackUsingTwoQueues() {
		s1= new LinkedList<>();
		s2=new LinkedList<>();
	}
	public int getSize() { 
		return s1.size();
	}

	public boolean isEmpty() {

		 return s1.isEmpty();
	}

	
	public void push(int element) {

		s1.add(element);

	}

	public int pop() {

		if(s1.size()==0)
			return -1;
		while(s1.size()>1)
		{
			s2.add(s1.poll());
		}
		int swapped=s1.poll();
		Queue<Integer> temp = s1;
		s1 = s2;
		s2 = temp;
		return swapped;
	}

	public int top() {
		if(s1.size()==0)
			return -1;
		while (s1.size() > 1) {
			s2.add(s1.poll());
		}
		int topElement = s1.peek();
		s2.add(s1.poll());
		Queue<Integer> temp = s1;
		s1 = s2;
		s2 = temp;
		return topElement;
	}
}
