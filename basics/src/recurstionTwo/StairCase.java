package recurstionTwo;

public class StairCase {

	public static int countWays(int n) {
        // Base cases
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        // Recursive relation
        return countWays(n - 1)
             + countWays(n - 2)
             + countWays(n - 3);
    }

    public static void main(String[] args) {
        System.out.println(countWays(3)); // 4
        //System.out.println(countWays(4)); // 7
        //System.out.println(countWays(5)); // 13
    }
}
