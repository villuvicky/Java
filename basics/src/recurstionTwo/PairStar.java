package recurstionTwo;

public class PairStar {

    public static String pairStar(String str) {
        // Base case: empty or single character
        if (str.length() <= 1) {
            return str;
        }

        // Recursive call on substring from index 1
        String smallAns = pairStar(str.substring(1));

        // If adjacent characters are same, add '*'
        if (str.charAt(0) == str.charAt(1)) {
            return str.charAt(0) + "*" + smallAns;
        } else {
            return str.charAt(0) + smallAns;
        }
    }

    public static void main(String[] args) {
        System.out.println(pairStar("aabb"));   // a*ab*b
        System.out.println(pairStar("aaabcc")); // a*a*ab*c*c
        System.out.println(pairStar("abcd"));   // abcd
    }
}

