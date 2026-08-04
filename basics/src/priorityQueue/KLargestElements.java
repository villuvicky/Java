package priorityQueue;

import java.util.ArrayList;
public class KLargestElements {
	public static ArrayList<Integer> kLargest(int input[], int k) {
		// Edge case
		k = Math.min(k, input.length);
		// Step 1: Create heap with first k elements
		ArrayList<Integer> heap = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			heap.add(input[i]);
		}
		// Step 2: Build Min Heap
		for (int i = (k / 2) - 1; i >= 0; i--) {
			downHeapify(heap, i, k);
		}
		// Step 3: Process remaining elements
		for (int i = k; i < input.length; i++) {
			if (input[i] > heap.get(0)) {
				heap.set(0, input[i]);   // replace root
				downHeapify(heap, 0, k);
			}
		}
		return heap;
	}
	// Heapify down (Min Heap)
	private static void downHeapify(ArrayList<Integer> heap, int i, int size) {
		int smallest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if (left < size && heap.get(left) < heap.get(smallest)) {
			smallest = left;
		}
		if (right < size && heap.get(right) < heap.get(smallest)) {
			smallest = right;
		}
		if (smallest != i) {
			int temp = heap.get(i);
			heap.set(i, heap.get(smallest));
			heap.set(smallest, temp);
			downHeapify(heap, smallest, size);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
