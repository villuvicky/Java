package queues;

public class QueueUsingLinkedListImp {

	public static void main(String[] args) {

		QueueUseLinkedList<Integer> queue= new QueueUseLinkedList<>();
		int arr[]= {10,20,30,40,50};

		for (int j : arr) {
			
		

			queue.enqueue(j);
		}

		while(!queue.isEmpty()) {
			System.out.println(queue.dequeue());

		}

	}

}
