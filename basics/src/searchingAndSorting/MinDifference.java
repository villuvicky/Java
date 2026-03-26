package searchingAndSorting;

import java.util.Arrays;

public class MinDifference {
	public static int minDifference(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0, j = 0;
        int minDiff = Integer.MAX_VALUE;

        while (i < arr1.length && j < arr2.length) {
            int diff = Math.abs(arr1[i] - arr2[j]);
            minDiff = Math.min(minDiff, diff);

            if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30};
        int[] arr2 = {17, 15};

        System.out.println(minDifference(arr1, arr2)); // 3
    }

}
