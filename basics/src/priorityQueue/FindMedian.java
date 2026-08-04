package priorityQueue;

import java.util.PriorityQueue;
import java.util.*;
public class FindMedian {
	  public static void findMedian(int[] arr) {

	        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	        for (int i = 0; i < arr.length; i++) {

	            int num = arr[i];

	            // Step 1: Add number
	            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
	                maxHeap.add(num);
	            } else {
	                minHeap.add(num);
	            }

	            // Step 2: Balance heaps
	            if (maxHeap.size() > minHeap.size() + 1) {
	                minHeap.add(maxHeap.poll());
	            } else if (minHeap.size() > maxHeap.size()) {
	                maxHeap.add(minHeap.poll());
	            }

	            // Step 3: Find median
	            if (maxHeap.size() == minHeap.size()) {
	                int median = (maxHeap.peek() + minHeap.peek()) / 2;
	                System.out.print(median + " ");
	            } else {
	                System.out.print(maxHeap.peek() + " ");
	            }
	        }
	    }
}
