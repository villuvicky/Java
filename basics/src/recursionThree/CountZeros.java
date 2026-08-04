package recursionThree;

public class CountZeros {

    public static int countZeros(int n) {
        // Special case
        if (n == 0) {
            return 1;
        }
        return helper(n);
    }

    private static int helper(int n) {
        // Base case
        if (n == 0) {
            return 0;
        }

        int lastDigit = n % 10;

        if (lastDigit == 0) {
            return 1 + helper(n / 10);
        } else {
            return helper(n / 10);
        }
    }

    public static void main(String[] args) {
        System.out.println(countZeros(10204)); // Output: 2
    }
}