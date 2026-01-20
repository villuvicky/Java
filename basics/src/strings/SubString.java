package strings;

public class SubString {
	
	public static void printSubstrings(String str) {
        int n = str.length();

        // starting index
        for (int i = 0; i < n; i++) {
            // ending index
            for (int j = i + 1; j <= n; j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }

	public static void main(String[] args) {
		
		printSubstrings("abcd");

	}

}
