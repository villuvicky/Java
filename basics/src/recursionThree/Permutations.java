package recursionThree;

public class Permutations {

    public static void printPermutations(String input) {
        helper(input, "");
    }

    private static void helper(String input, String output) {
        // Base case
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        // Try fixing each character
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            // Remaining string after removing current char
            String remaining = input.substring(0, i) + input.substring(i + 1);

            helper(remaining, output + current);
        }
    }

    public static void main(String[] args) {
        printPermutations("abc");
    }
}
