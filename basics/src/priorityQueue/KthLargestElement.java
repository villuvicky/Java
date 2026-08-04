

package priorityQueue;
import java.util.PriorityQueue;


public class KthLargestElement {
	public static int kthLargest(int n, int[] input, int k) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		        for (int num : input) {
		            minHeap.add(num);

		            if (minHeap.size() > k) {
		                minHeap.poll(); 
		            }
		        }

		        return minHeap.peek();
		    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
