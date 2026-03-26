package recurstionTwo;

public class CheckAB {

    public static boolean checkAB(String str) {
        // Rule 1: string must start with 'a'
        if (str.length() == 0) {
            return true;
        }

        if (str.charAt(0) != 'a') {
            return false;
        }

        return checkRules(str);
    }

    private static boolean checkRules(String str) {
        // Base case
        if (str.length() == 0) {
            return true;
        }

        // If string starts with 'a'
        if (str.charAt(0) == 'a') {
            // Case 1: followed by "bb"
            if (str.length() >= 3 &&
                str.charAt(1) == 'b' &&
                str.charAt(2) == 'b') {
                return checkRules(str.substring(3));
            }
            // Case 2: followed by 'a' or nothing
            return checkRules(str.substring(1));
        }

        // If string starts with 'b', it must be "bb"
        if (str.length() >= 2 &&
            str.charAt(0) == 'b' &&
            str.charAt(1) == 'b') {
            return checkRules(str.substring(2));
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkAB("abb"));     // true
        System.out.println(checkAB("abba"));    // true
        System.out.println(checkAB("abbabb"));  // true
        System.out.println(checkAB("abab"));    // false
        System.out.println(checkAB("bb"));      // false
    }
}

