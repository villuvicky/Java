package stacks;

import java.util.Stack;

public class ReverseStack {

    public static void reverseStack(Stack<Integer> stack1, Stack<Integer> stack2) {

        // Step 1: Move all elements to stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // Step 2: Move back to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public static void main(String[] args) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);

        reverseStack(stack1, stack2);

        System.out.println(stack1);
    }
}

