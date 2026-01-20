package strings;

public class RemoveDuplicate {
	 public static String removeConsecutiveDuplicates(String str) {
	        if (str == null || str.length() == 0) {
	            return str;
	        }

	        StringBuilder result = new StringBuilder();
	        result.append(str.charAt(0));

	        for (int i = 1; i < str.length(); i++) {
	            if (str.charAt(i) != str.charAt(i - 1)) {
	                result.append(str.charAt(i));
	            }
	        }
	        return result.toString();
	    }

	public static void main(String[] args) {
		
		String str="aabccbaa";
		System.out.println(removeConsecutiveDuplicates(str));
	}

}
