package hashMaps;

import java.util.HashMap;

public class MaximumFrequencyOfNumber {
	
	 public static int maxFrequencyNumber(int[] arr){ 
		 HashMap<Integer, Integer> map= new HashMap<>();
		 for (int num : arr) {
			 map.put(num, map.getOrDefault(num, 0)+1);
		}
		 int maxFreq=0;
		 int answer=arr[0];
		 for (int num : arr) {
			
			 if(map.get(num)>maxFreq)
			 {
				 maxFreq=map.get(num);
				 answer=num;
			 }
		}
		 return answer;
	 }
	public static void main(String[] args) {
		  int[] arr = {2, 12, 2, 11, 12, 2, 1, 12};
		  System.out.println(maxFrequencyNumber(arr));
	}

}
