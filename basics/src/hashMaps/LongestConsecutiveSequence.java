package hashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence {

	public static ArrayList<Integer> longestSequence(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        // Step 1: Fill set & index map
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            indexMap.put(arr[i], i);
        }
        int bestLen = 0;
        int start = 0;
        // Step 2: Traverse array
        for (int num : arr) {
            // check if it's a starting point
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int length = 1;
                // expand forward
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }
                // update result
                if (length > bestLen) {
                    bestLen = length;
                    start = num;
                } else if (length == bestLen) {
                    if (indexMap.get(num) < indexMap.get(start)) {
                        start = num;
                    }
                }
            }
        }
        // Step 3: Prepare ArrayList result
        ArrayList<Integer> result = new ArrayList<>();
        if (bestLen == 1) {
            result.add(start);
            return result;
        }
        result.add(start);
        result.add(start + bestLen - 1);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};

        ArrayList<Integer> res = longestSequence(arr);

        System.out.println(res);
    }
}
