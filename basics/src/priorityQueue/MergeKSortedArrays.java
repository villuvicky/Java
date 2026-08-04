package priorityQueue;

import java.util.*;
import java.util.PriorityQueue;
class Solution {

    static class Element {
        int value;
        int arrIndex;
        int elementIndex;

        Element(int value, int arrIndex, int elementIndex) {
            this.value = value;
            this.arrIndex = arrIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {

        ArrayList<Integer> result = new ArrayList<>();

        // Min Heap based on value
        PriorityQueue<Element> minHeap = new PriorityQueue<>(
            (a, b) -> a.value - b.value
        );

        // Step 1: Add first element of each array
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).size() > 0) {
                minHeap.add(new Element(input.get(i).get(0), i, 0));
            }
        }

        // Step 2: Process heap
        while (!minHeap.isEmpty()) {
            Element current = minHeap.poll();
            result.add(current.value);

            int nextIndex = current.elementIndex + 1;

            // Add next element from same array
            if (nextIndex < input.get(current.arrIndex).size()) {
                minHeap.add(new Element(
                    input.get(current.arrIndex).get(nextIndex),
                    current.arrIndex,
                    nextIndex
                ));
            }
        }

        return result;
    }
}