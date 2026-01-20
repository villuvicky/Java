package arrays2;

import java.util.Scanner;

public class CheckArrayRotation {

	 // Function to find rotation count (index of minimum element)
    public static int findRotationCount(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();   // number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();   // size of array
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(findRotationCount(arr));
        }
        sc.close();

	}

}
