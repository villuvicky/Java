package recursionThree;

public class PrintAllPossibleCodes {
	public static void printAllPossibleCodes(String input) {
        printHelper(input, "");
    }

    private static void printHelper(String input, String output) {

        // Base case
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        // Take 1 digit
        int firstDigit = input.charAt(0) - '0';
        char firstChar = (char) ('a' + firstDigit - 1);

        printHelper(input.substring(1), output + firstChar);

        // Take 2 digits (if valid)
        if (input.length() >= 2) {
            int firstTwoDigits = Integer.parseInt(input.substring(0, 2));

            if (firstTwoDigits <= 26) {
                char secondChar = (char) ('a' + firstTwoDigits - 1);
                printHelper(input.substring(2), output + secondChar);
            }
        }
    }
	public static void main(String[] args) {
		printAllPossibleCodes("1234");

	}

}
