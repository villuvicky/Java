package priorityQueue;

import java.util.ArrayList;

public class PriorityQueue<T> {


	private ArrayList<Element <T>> heap;

	public PriorityQueue() {
		heap = new ArrayList<>();
	}

	public void insert(T value , int priority) {

		Element<T> e= new Element<>(value, priority);
		heap.add(e);
		int childIndex=heap.size()-1;
		int parentIndex=(childIndex-1)/2;
		
		if(heap.get(childIndex).priority<heap.get(parentIndex).priority) {
			Element<T> temp= heap.get(childIndex);
			heap.set(childIndex, heap.get(parentIndex));
			heap.set(parentIndex, temp);
		}
		
	}
	public T getMin() {
		if(isEmpty())
			return null;
		
		return heap.get(0).value;
	}

	public T removeMin() {
		if (isEmpty()) {
			return null;
		}

		// Step 1: Store min element
		int min = heap.get(0);

		// Step 2: Move last element to root
		heap.set(0, heap.get(heap.size() - 1));

		// Step 3: Remove last element
		heap.remove(heap.size() - 1);

		// Step 4: Heapify down
		int parentIndex = 0;

		while (true) {
			int leftChildIndex = 2 * parentIndex + 1;
			int rightChildIndex = 2 * parentIndex + 2;
			int minIndex = parentIndex;

			// Compare with left child
			if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(minIndex)) {
				minIndex = leftChildIndex;
			}

			// Compare with right child
			if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)) {
				minIndex = rightChildIndex;
			}

			// If parent is already smallest → stop
			if (minIndex == parentIndex) {
				break;
			}

			// Swap
			int temp = heap.get(parentIndex);
			heap.set(parentIndex, heap.get(minIndex));
			heap.set(minIndex, temp);

			parentIndex = minIndex;
		}

		return min;
	}

	public int size() {
		return heap.size();
	}

	public boolean isEmpty() {

		return size()==0;

	}
}
