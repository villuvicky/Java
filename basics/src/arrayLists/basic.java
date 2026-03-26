package arrayLists;

import java.util.ArrayList;

public class basic {

	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<>(); //() represents the capacity of array
		arr.add(1);
		arr.add(2);
		arr.add(3);
		System.out.println(arr);
		System.out.println(arr.size());
		arr.add(0, 2); // here first attribute is index and next is value, it moves all values to right
		System.out.println(arr);
		arr.set(0, 1); //this method replaces the value.
		System.out.println(arr);
		arr.remove(0);//remove index specified
		Integer i=2;
		arr.remove(i);// by passing the object , we can remove specified value of first occurrence
		System.out.println(arr);
		
	}

}
