package searchingAndSorting;

import java.util.Arrays;

public class CountSmall {
	
	 public static int[] countSmallerOrEqual(int[] A, int[] B) {
	        Arrays.sort(B); // Step 1

	        int[] result = new int[A.length];

	        for (int i = 0; i < A.length; i++) {
	            result[i] = upperBound(B, A[i]);
	        }

	        return result;
	    }

	    // returns count of elements <= key
	    private static int upperBound(int[] arr, int key) {
	        int low = 0, high = arr.length - 1;
	        int ans = -1;

	        while (low <= high) {
	            int mid = low + (high - low) / 2;

	            if (arr[mid] <= key) {
	                ans = mid;
	                low = mid + 1;
	            } else {
	                high = mid - 1;
	            }
	        }
	        return ans + 1; // count
	    }

	public static void main(String[] args) {
		  int[] arr1 = {10, 20, 30};
	        int[] arr2 = {17, 18};

	        int[] result= countSmallerOrEqual(arr1, arr2); // 3
	        for (int i : result) {
				System.out.println(i+" ");
			}
	     
	     
	}

}
