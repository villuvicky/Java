package strings;

public class CompressString {
	
	
	
	public static String getCompressedString(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        StringBuilder result = new StringBuilder();

        int count = 1;

        for (int i = 1; i <= str.length(); i++) {

            // if current char is same as previous, increase count
            if (i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                // append previous character
                result.append(str.charAt(i - 1));

                // append count only if more than 1
                if (count > 1) {
                    result.append(count);
                }

                // reset count for next character
                count = 1;
            }
        }

        return result.toString();
    }

	public static void main(String[] args) {
		System.out.println(getCompressedString("aaabbccdsa"));
	}

}
