package stacks;

import java.util.Stack;

public class Redundant {
	
	public static boolean checkRedundantBrackets(String expression) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (ch == ')') {

                boolean operatorFound = false;

                while (!stack.isEmpty() && stack.peek() != '(') {

                    char top = stack.pop();

                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        operatorFound = true;
                    }
                }

                stack.pop(); // remove '('

                if (!operatorFound) {
                    return true; // redundant
                }
            } 
            else {
                stack.push(ch);
            }
        }

        return false; // no redundant brackets
    }

	public static void main(String[] args) {
		
		System.out.println(checkRedundantBrackets("a+b+(ac)"));

	}

}
