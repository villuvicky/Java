package stacks;

public class StackLLImplement {

	public static void main(String[] args) {
		
		StackUsingLinkedList<Integer> sl= new StackUsingLinkedList<>();
		int arr[]= {1,2,3};
		
		for(int i=1;i<arr.length;i++) {
			sl.push(arr[i]);
		}
		System.out.println(sl.top());
	}

}
