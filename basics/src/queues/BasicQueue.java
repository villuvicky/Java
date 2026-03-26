package queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BasicQueue {

	public static void main(String[] args) {
		
		Queue<Integer> queue= new LinkedList<Integer>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		
		for (Integer integer : queue) {
			System.out.println(integer);
		}
		Queue<Integer> q=new LinkedList<Integer>();
        Stack<Integer> s=new Stack<Integer>();
        q.add(5);
        q.add(10);
        s.push(10);
        s.push(20);
        System.out.print(q.peek()+s.pop());
	}

}
