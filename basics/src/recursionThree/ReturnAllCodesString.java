package recursionThree;

import java.util.ArrayList;

public class ReturnAllCodesString {
    public static String[] getCodes(String input) {
        // Base case
        if (input.length() == 0) {
            return new String[]{""};
        }

        // Take 1 digit
        int firstDigit = input.charAt(0) - '0';
        char firstChar = (char) ('a' + firstDigit - 1);

        String[] smallAns1 = getCodes(input.substring(1));
        ArrayList<String> result = new ArrayList<>();

        for (String s : smallAns1) {
            result.add(firstChar + s);
        }

        // Take 2 digits (if valid)
        if (input.length() >= 2) {
            int firstTwoDigits = Integer.parseInt(input.substring(0, 2));

            if (firstTwoDigits <= 26) {
                char secondChar = (char) ('a' + firstTwoDigits - 1);

                String[] smallAns2 = getCodes(input.substring(2));

                for (String s : smallAns2) {
                    result.add(secondChar + s);
                }
            }
        }

        return result.toArray(new String[0]);
    }
	public static void main(String[] args) {
	
		String output[] = getCodes("1234");
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
		
	}

}
