package strings;

public class CheckPermutations {
	
	public static boolean isPermutation(String str1, String str2) {

        // Step 1: If lengths differ, cannot be permutations
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] freq = new int[26];

        // Step 2: Count characters of str1
        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i) - 'a']++;
        }

        // Step 3: Reduce count using str2
        for (int i = 0; i < str2.length(); i++) {
            freq[str2.charAt(i) - 'a']--;

            // If count goes negative → extra character in str2
            if (freq[str2.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        // Step 4: All counts matched
        return true;
    }

	public static void main(String[] args) {
		
		System.out.println(isPermutation("abcd", "dbca"));
	}

}
