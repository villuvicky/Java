package arrays2;

import java.util.Arrays;

public class TripletSum {

    public static int tripletSum(int[] arr, int x) {
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum < x) {
                    left++;
                } else if (sum > x) {
                    right--;
                } else {
                    // sum == x
                    if (arr[left] == arr[right]) {
                        int elements = right - left + 1;
                        count += (elements * (elements - 1)) / 2;
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
        }

        return count;
    }
    
    public static void main(String args[]) {
    	
    	int ARR []= {1, 2, 3, 4, 5, 6};
    			int X = 8;
    			System.out.println(tripletSum(ARR, X));

    }
}

