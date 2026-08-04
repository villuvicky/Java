package recursionThree;

public class MinRecursive {

    public static int findMin(int[] arr, int index) {
        // Base case
        if (index == arr.length - 1) {
            return arr[index];
        }

        // Recursive call
        int smallMin = findMin(arr, index + 1);

        // Return minimum
        return Math.min(arr[index], smallMin);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 6};
        System.out.println(findMin(arr, 0));
    }
}
