package recursionThree;

public class Staircase {

    public static int staircase(int n) {
        // Base cases
        if (n == 0) return 1;
        if (n < 0) return 0;

        // Recursive relation
        return staircase(n - 1) + staircase(n - 2) + staircase(n - 3);
    }

    public static void main(String[] args) {
        System.out.println(staircase(4)); // Output: 7
    }
}