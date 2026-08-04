package hashMaps;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {

	public static void main(String[] args) {
	
		int a []= {1,2,2,3,4,3};
		ArrayList<Integer> result= new ArrayList<>();
		HashMap<Integer, Boolean> map= new HashMap<>();
		
		for (Integer integer : a) {
			if(!map.containsKey(integer)) {
				result.add(integer);
				map.put(integer, true);
			}
		}
		
		System.out.println(result);
	}

}
