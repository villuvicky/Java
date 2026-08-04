package binaryTreeSearch;

import java.util.*;

public class LongestZeroSumSubarray {
    public static int maxLen(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Case 1: sum becomes 0
            if (sum == 0) {
                maxLen = i + 1;
            }

            // Case 2: sum seen before
            if (map.containsKey(sum)) {
                int prevIndex = map.get(sum);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                // store first occurrence only
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {6, -1, -3, 4, -2, 2, 4, 6, -12, -7};

        System.out.println(maxLen(arr));
    }
}
