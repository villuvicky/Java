package stacks;

import java.util.Stack;

public class BalancedParanthesis {
	
	public static boolean isBalanced(String expression) {
		Stack <Character> stack= new Stack<>();
		for(int i=0;i<expression.length();i++) {
			char ch= expression.charAt(i);
			if(ch=='(') {
				stack.push(ch);
			}
			else if(ch==')')
			{
				if(stack.isEmpty())
					return false;
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {

		System.out.println(isBalanced("(()()()))")); 

	}

}
