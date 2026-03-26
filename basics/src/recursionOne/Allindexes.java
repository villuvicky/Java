package recursionOne;

public class Allindexes {

	public static int[] allIndexes(int[] input, int x) {
        return helper(input, x, 0);
    }

    private static int[] helper(int[] input, int x, int index) {

        // Base case: reached end
        if (index == input.length) {
            return new int[0];
        }

        // Recursive call
        int[] smallAns = helper(input, x, index + 1);

        // If current element matches x
        if (input[index] == x) {
            int[] ans = new int[smallAns.length + 1];
            ans[0] = index;

            // copy previous indexes
            for (int i = 0; i < smallAns.length; i++) {
                ans[i + 1] = smallAns[i];
            }
            return ans;
        }

        // If no match, just return previous result
        return smallAns;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 2};
        int[] result = allIndexes(arr, 1);

        for (int i : result) {
            System.out.print(i + " ");
        }
        // Output: 1 2 4
    }

}
