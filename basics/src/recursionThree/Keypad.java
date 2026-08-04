package recursionThree;

public class Keypad {

    static String[] keypad = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public static void printKeypad(int n) {
        helper(n, "");
    }

    private static void helper(int n, String output) {
        // Base case
        if (n == 0) {
            System.out.println(output);
            return;
        }

        int digit = n % 10;
        String letters = keypad[digit];

        // If digit is 0 or 1 → skip
        if (letters.length() == 0) {
            helper(n / 10, output);
            return;
        }

        // Try all characters for current digit
        for (int i = 0; i < letters.length(); i++) {
            helper(n / 10, letters.charAt(i) + output);
        }
    }

    public static void main(String[] args) {
        printKeypad(23);
    }
}
