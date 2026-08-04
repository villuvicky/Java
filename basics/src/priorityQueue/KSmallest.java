package priorityQueue;

import java.util.ArrayList;

public class KSmallest {



	public static ArrayList<Integer> kSmallest(int[] input, int k) {

		k = Math.min(k, input.length);

		// Step 1: Take first k elements
		ArrayList<Integer> heap = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			heap.add(input[i]);
		}

		// Step 2: Build Max Heap
		for (int i = (k / 2) - 1; i >= 0; i--) {
			downHeapify(heap, i, k);
		}

		// Step 3: Process remaining elements
		for (int i = k; i < input.length; i++) {
			if (input[i] < heap.get(0)) {
				heap.set(0, input[i]);   // replace largest
				downHeapify(heap, 0, k);
			}
		}

		return heap;
	}

	// Max Heapify
	private static void downHeapify(ArrayList<Integer> heap, int i, int size) {
		int largest = i;

		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < size && heap.get(left) > heap.get(largest)) {
			largest = left;
		}

		if (right < size && heap.get(right) > heap.get(largest)) {
			largest = right;
		}

		if (largest != i) {
			int temp = heap.get(i);
			heap.set(i, heap.get(largest));
			heap.set(largest, temp);

			downHeapify(heap, largest, size);
		}
	}
}


