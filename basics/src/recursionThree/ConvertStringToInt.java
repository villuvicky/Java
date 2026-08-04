package recursionThree;

public class ConvertStringToInt {
	
	public static int convertStringToInt(String input) {
        // Base case
        if (input.length() == 1) {
            return input.charAt(0) - '0';
        }

        // Recursive call on smaller string
        int smallAns = convertStringToInt(input.substring(0, input.length() - 1));

        // Last digit
        int lastDigit = input.charAt(input.length() - 1) - '0';

        // Combine result
        return smallAns * 10 + lastDigit;
    }
	
	
	 public static void main(String[] args) {
	        System.out.println(convertStringToInt("00001231")); // Output: 7
	    }

}
