package backtTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        solve(s, 0, current, result);

        return result;
    }

    private static void solve(String s,
                              int start,
                              List<String> current,
                              List<List<String>> result) {

        // If we have processed the entire string,
        // current contains one valid palindrome partition.
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every possible substring starting at 'start'
        for (int end = start; end < s.length(); end++) {

            // Check if s[start...end] is a palindrome
            if (isPalindrome(s, start, end)) {

                // Choose this palindrome substring
                current.add(s.substring(start, end + 1));

                // Recur for remaining part of string
                solve(s, end + 1, current, result);

                // Backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        String s = "BaaB";

        List<List<String>> ans = partition(s);

        for (List<String> partition : ans) {
            System.out.println(partition);
        }
    }
}
