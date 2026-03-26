package recurstionTwo;

public class StringToInteger {
	public static int stringToNumber(String str) {
        // Base case
        if (str.length() == 1) {
            return str.charAt(0) - '0';
        }

        // Recursive call
        int smallAns = stringToNumber(str.substring(0, str.length() - 1));

        // Convert last character to digit
        int lastDigit = str.charAt(str.length() - 1) - '0';

        // Combine result
        return smallAns * 10 + lastDigit;
    }

    public static void main(String[] args) {
        System.out.println(stringToNumber("1234")); // 1234
        //System.out.println(stringToNumber("0"));    // 0
        //System.out.println(stringToNumber("507"));  // 507
}
}