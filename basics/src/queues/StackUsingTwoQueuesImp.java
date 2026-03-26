package queues;

public class StackUsingTwoQueuesImp {

	public static void main(String[] args) {
		
		StackUsingTwoQueues sq= new StackUsingTwoQueues();
		
		int arr[]= {1,2,3,4};
		
		for (int i : arr) {
			sq.push(i);
		}
		
		System.out.println(sq.top());
	}

}
