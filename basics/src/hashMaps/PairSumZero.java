package hashMaps;

import java.util.*;

public class PairSumZero {
    public static int countPairs(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Build frequency map
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        for (int num : arr) {
            if (map.containsKey(-num)) {
                count += map.get(-num);
            }

            // Handle case when num == 0
            if (num == 0) {
                count--; // remove self pairing
            }
        }

        return count / 2; // each pair counted twice
    }

    public static void main(String[] args) {
        int[] arr = {2,1,-2,2,3};
        System.out.println(countPairs(arr));
    }
}