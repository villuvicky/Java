package hashMaps;

import java.util.HashSet;

public class RemoveDuplicatesString {

	 public static String removeDuplicates(String s) {
	        HashSet<Character> set = new HashSet<>();
	        StringBuilder result = new StringBuilder();
	        for (char ch : s.toCharArray()) {
	            if (!set.contains(ch)) {
	                set.add(ch);
	                result.append(ch);
	            }
	        }
	        return result.toString();
	    }
	    public static void main(String[] args) {
	        String s = "programming";
	        System.out.println(removeDuplicates(s));
	    }
}
