package arrays2;

import java.util.Arrays;

public class PairSum {

	public static int pairSum(int[] arr, int num) {
	    Arrays.sort(arr);
	    int left = 0, right = arr.length - 1;
	    int count = 0;

	    while (left < right) {
	        int sum = arr[left] + arr[right];

	        if (sum < num) {
	            left++;
	        } else if (sum > num) {
	            right--;
	        } else {
	            // arr[left] + arr[right] == num

	            if (arr[left] == arr[right]) {
	                int n = right - left + 1;
	                count += (n * (n - 1)) / 2;
	                break;
	            }

	            int leftVal = arr[left];
	            int rightVal = arr[right];
	            int leftCount = 0, rightCount = 0;

	            while (left < right && arr[left] == leftVal) {
	                leftCount++;
	                left++;
	            }

	            while (right >= left && arr[right] == rightVal) {
	                rightCount++;
	                right--;
	            }

	            count += leftCount * rightCount;
	        }
	    }

	    return count;
	}
	 public static int findPair(int[] arr, int x) {
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
		
		int [] arr=  {3, 2, 3, 4};
		int x=6;
		System.out.println(findPair(arr, x));
		System.out.println(pairSum(arr, x));
	}
}
