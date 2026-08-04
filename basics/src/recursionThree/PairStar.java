package recursionThree;

public class PairStar {
	
	public static String pairStar(String input) {
        // Base case
        if (input.length() <= 1) {
            return input;
        }

        // Recursive call for smaller string
        String smallAns = pairStar(input.substring(1));

        // Check first char and next char
        if (input.charAt(0) == input.charAt(1)) {
            return input.charAt(0) + "*" + smallAns;
        } else {
            return input.charAt(0) + smallAns;
        }
    }

	public static void main(String[] args) {
	
		System.out.println(pairStar("hello"));

	}

}
