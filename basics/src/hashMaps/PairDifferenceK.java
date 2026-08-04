package hashMaps;

import java.util.*;

public class PairDifferenceK {
    public static int countPairs(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Build frequency map
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        // Case 1: K = 0
        if (k == 0) {
            for (int freq : map.values()) {
                count += (freq * (freq - 1)) / 2;
            }
            return count;
        }

        // Case 2: K > 0
        for (int num : map.keySet()) {
            if (map.containsKey(num + k)) {
                count += map.get(num) * map.get(num + k);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        int k = 2;

        System.out.println(countPairs(arr, k));
    }
}
