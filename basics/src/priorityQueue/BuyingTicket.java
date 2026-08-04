package priorityQueue;

import java.util.*;
import java.util.PriorityQueue;
class Person {
    int index;
    int priority;

    Person(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

public class BuyingTicket {

    public static int buyTicket(int[] arr, int k) {

        Queue<Person> queue = new LinkedList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Step 1: Initialize
        for (int i = 0; i < arr.length; i++) {
            queue.add(new Person(i, arr[i]));
            maxHeap.add(arr[i]);
        }

        int time = 0;

        // Step 2: Process queue
        while (!queue.isEmpty()) {
            Person current = queue.poll();

            if (current.priority < maxHeap.peek()) {
                // Move to back
                queue.add(current);
            } else {
                // Give ticket
                time++;
                maxHeap.poll();

                if (current.index == k) {
                    return time;
                }
            }
        }

        return time;
    }
}