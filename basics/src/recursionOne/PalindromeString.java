package recursionOne;

public class PalindromeString {
	public static boolean isPalindrome(String s) {
        return check(s, 0, s.length() - 1);
    }

    private static boolean check(String s, int start, int end) {

        // Base case: crossed or single character
        if (start >= end) {
            return true;
        }

        // If characters don't match
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }

        // Recursive call for inner substring
        return check(s, start + 1, end - 1);
    }

	public static void main(String[] args) {
		System.out.println(isPalindrome("racecar")); // true
        System.out.println(isPalindrome("coding"));  // false

	}

}
