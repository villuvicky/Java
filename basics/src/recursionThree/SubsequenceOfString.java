package recursionThree;

import java.util.ArrayList;

public class SubsequenceOfString {
	
	public static String[] getSubsequences(String str) {
		  // Base case
        if (str.length() == 0) {
            return new String[]{""};
        }

        // Recursive call
        String[] smallAns = getSubsequences(str.substring(1));

        // Create result array
        String[] ans = new String[2 * smallAns.length];

        // Fill result
        int k = 0;

        // बिना current char
        for (int i = 0; i < smallAns.length; i++) {
            ans[k++] = smallAns[i];
        }

        // with current char
        for (int i = 0; i < smallAns.length; i++) {
            ans[k++] = str.charAt(0) + smallAns[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "abc";
        String[] result = getSubsequences(str);

        for (String s : result) {
            System.out.println(s);
        }
    }

}
