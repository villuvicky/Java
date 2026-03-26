package queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueReverseKtimes {

	public static Queue<Integer> reverse(Queue<Integer> input, int k) {


		if(k==0|| input.isEmpty()||k>input.size()||k<=0) {
			return input;
		}

		reverseK(input, k);
		
		int remaining =input.size()-k;
		
		for(int i=0;i<remaining;i++) {
			
			input.add(input.poll());
		}
		return input;

	}

	public static void reverseK(Queue<Integer> input, int k) {

		if(k==0)
			return ;

		int top=input.poll();
		reverseK(input, k-1);
		input.add(top);
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
		reverse(queue,3);

		System.out.println("Reversed Queue: " + queue);

	}

}
