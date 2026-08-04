package backtTracking;

import java.util.*;

public class CombinationSum {

    public static List<List<Integer>> combSum(int[] ARR, int B) {
        // Sort the array so combinations are generated
        // in non-decreasing order.
        Arrays.sort(ARR);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(ARR, 0, B, current, result);

        return result;
    }

    private static void solve(int[] arr,
                              int index,
                              int target,
                              List<Integer> current,
                              List<List<Integer>> result) {

        // Valid combination found
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // No more elements or target becomes negative
        if (index == arr.length || target < 0) {
            return;
        }

        // Option 1: Include current element
        // Since an element can be used unlimited times,
        // we keep the same index.
        if (arr[index] <= target) {
            current.add(arr[index]);
            solve(arr, index, target - arr[index], current, result);
            current.remove(current.size() - 1); // Backtrack
        }

        // Option 2: Exclude current element
        // Move to next index.
        solve(arr, index + 1, target, current, result);
    }

    // Optional main method for testing
    public static void main(String[] args) {
        int[] ARR = {1, 2, 3};
        int B = 5;

        List<List<Integer>> ans = combSum(ARR, B);

        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
