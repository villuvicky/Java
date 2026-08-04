package recursionThree;

public class Subsets {

    public static int[][] subsets(int[] input) {
        return helper(input, 0);
    }

    private static int[][] helper(int[] input, int index) {
        // Base case
        if (index == input.length) {
            return new int[][] { {} }; // one subset: empty
        }

        // Recursive call
        int[][] smallAns = helper(input, index + 1);

        int[][] output = new int[smallAns.length * 2][];

        // Copy subsets without current element
        for (int i = 0; i < smallAns.length; i++) {
            output[i] = smallAns[i];
        }

        // Copy subsets with current element
        for (int i = 0; i < smallAns.length; i++) {
            output[i + smallAns.length] = new int[smallAns[i].length + 1];
            output[i + smallAns.length][0] = input[index];

            for (int j = 0; j < smallAns[i].length; j++) {
                output[i + smallAns.length][j + 1] = smallAns[i][j];
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[][] result = subsets(arr);

        for (int[] subset : result) {
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
