
package stacks;
import java.util.Stack;
public class MinimumBracketReversal {
		
	    public static int countBracketReversals(String input) {

	        if (input.length() % 2 != 0) {
	            return -1;
	        }

	        Stack<Character> stack = new Stack<>();

	        for (int i = 0; i < input.length(); i++) {

	            char ch = input.charAt(i);

	            if (ch == '{') {
	                stack.push(ch);
	            } 
	            else { // ch == '}'

	                if (!stack.isEmpty() && stack.peek() == '{') {
	                    stack.pop();
	                } 
	                else {
	                    stack.push(ch);
	                }
	            }
	        }

	        int open = 0;
	        int close = 0;

	        while (!stack.isEmpty()) {
	            if (stack.pop() == '{') {
	                open++;
	            } else {
	                close++;
	            }
	        }

	        return (open + 1) / 2 + (close + 1) / 2;
	    }
	


	public static void main(String[] args) {
		System.out.println(countBracketReversals("{{{{}}"));

	}

}
