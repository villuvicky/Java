package arrays2;

public class CountTriplets {
	
	
	 public static int findTriplet(int[] arr, int x) {
	        int n = arr.length;
	        int count = 0;

	        for (int i = 0; i < n - 2; i++) {
	            for (int j = i + 1; j < n - 1; j++) {
	                for (int k = j + 1; k < n; k++) {
	                    if (arr[i] + arr[j] + arr[k] == x) {
	                        count++;
	                    }
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
