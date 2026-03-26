package recurstionTwo;

public class CuntZeros {

	public static int countZeros(int n) {
        // Special case: if number is 0, it has one zero
        if (n == 0) {
            return 1;
        }
        return countZerosHelper(n);
    }

    private static int countZerosHelper(int n) {
        // Base case
        if (n == 0) {
            return 0;
        }

        // Check last digit
        int count = (n % 10 == 0) ? 1 : 0;

        // Recursive call
        return count + countZerosHelper(n / 10);
    }

    public static void main(String[] args) {
        System.out.println(countZeros(102030)); // Output: 3
        System.out.println(countZeros(5000));   // Output: 3
        System.out.println(countZeros(0007));      // Output: 0
        System.out.println(countZeros(0));      // Output: 1
    }

}
