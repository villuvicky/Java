package recursionThree;

public class Subsequences {

    public static void printSubsequences(String input) {
        helper(input, "");
    }

    private static void helper(String input, String output) {
        // Base case
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        // Exclude current character
        helper(input.substring(1), output);

        // Include current character
        helper(input.substring(1), output + input.charAt(0));
    }

    public static void main(String[] args) {
        printSubsequences("abc");
    }
}
