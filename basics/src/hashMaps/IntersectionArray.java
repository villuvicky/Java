package hashMaps;

import java.util.*;

public class IntersectionArray {
    public static void intersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Step 1: Store frequency of arr1
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Step 2: Traverse arr2 and print intersection
        for (int num : arr2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                System.out.print(num + " ");
                map.put(num, map.get(num) - 1);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {2, 6, 8, 5, 4, 3};
        int[] arr2 = {2, 3, 4, 7};
        intersection(arr1, arr2);
    }
}
