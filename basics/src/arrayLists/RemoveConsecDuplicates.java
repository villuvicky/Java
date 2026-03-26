package arrayLists;

import java.util.ArrayList;

public class RemoveConsecDuplicates {
	
	public static void consec(int arr[]) {
		
		ArrayList<Integer> arr2=new ArrayList<>();
		arr2.add(arr[0]);
		for(int i=1;i<arr.length;i++) {
			
			if(arr[i-1]!=arr[i])
				arr2.add(arr[i]);
		}
		System.out.println(arr2);
	}
	

	public static void main(String[] args) {
		
		int arr[]= {10,10,20,30,30,30,20};
		
		consec(arr);
	}

}
