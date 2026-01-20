package arrays2;

public class PairSum {


	 public static int findTriplet(int[] arr, int x) {
	        int n = arr.length;
	        int count = 0;

	        for (int i = 0; i < n - 1; i++) {
	            for (int j = i + 1; j < n ; j++) {
	                
	                    if (arr[i] + arr[j]  == x) {
	                        count++;
	                    
	                }
	            }
	        }
	        return count;
	    }

	public static void main(String[] args) {
		
		int [] arr=  {1, 2, 3, 4};
		int x=6;
		System.out.println(findTriplet(arr, x));

	}
}
