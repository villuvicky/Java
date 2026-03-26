package stacks;

public class StackArrayImplement {

	public static void main(String[] args) throws StackFullException {
		
		StackUsingArray arr=new StackUsingArray();
		System.out.println(arr.isEmpty());
		arr.push(50);
		arr.push(40);
		arr.push(30);
		arr.push(20);
		System.out.println(arr.isEmpty());
		System.out.println(arr.size());
		System.out.println(arr.top());
		System.out.println(arr.pop());

	}

}
