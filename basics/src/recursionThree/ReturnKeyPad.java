package recursionThree;

public class ReturnKeyPad {
	 static String[] keypadMap = {
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

		    public static String[] keypad(int n) {

		        // Base case
		        if (n == 0) {
		            String[] base = {""};
		            return base;
		        }

		        // Recursive call
		        String[] smallAns = keypad(n / 10);

		        int digit = n % 10;
		        String options = keypadMap[digit];

		        // If digit is 0 or 1 → just return previous
		        if (options.length() == 0) {
		            return smallAns;
		        }

		        // Create result array
		        String[] result = new String[smallAns.length * options.length()];

		        int k = 0;

		        // Combine
		        for (int i = 0; i < smallAns.length; i++) {
		            for (int j = 0; j < options.length(); j++) {
		                result[k] = smallAns[i] + options.charAt(j);
		                k++;
		            }
		        }

		        return result;
		    }

	public static void main(String[] args) {
		String output[] = keypad(123);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
		System.out.println();

	}

}
