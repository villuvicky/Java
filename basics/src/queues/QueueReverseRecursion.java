package queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueReverseRecursion {
	
	public static void reverse(Queue<Integer> queue) {
		
		if(queue.isEmpty())
			return ;
		
		int top=queue.poll();
		reverse(queue);
		
		queue.add(top);
		
	}
	
	

	public static void main(String[] args) {
		
	    Queue<Integer> queue = new LinkedList<>();

        // Adding elements
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println("Original Queue: " + queue);

        // Reverse the queue
        reverse(queue);

        System.out.println("Reversed Queue: " + queue);

	}

}
