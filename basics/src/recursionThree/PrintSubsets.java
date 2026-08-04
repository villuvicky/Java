package recursionThree;

import java.util.ArrayList;

public class PrintSubsets {
	
	public static void printSubsets(int[] input) {
        helper(input, 0, new ArrayList<>());
    }

    private static void helper(int[] input, int index, ArrayList<Integer> current) {

        // Print current subset
        for (int num : current) {
            System.out.print(num + " ");
        }
        System.out.println();

        if (index >= input.length) return;

        int i = index;

        while (i < input.length) {

            // Include current element
            current.add(input[i]);
            helper(input, i + 1, current);
            current.remove(current.size() - 1);

            // Skip duplicates
            int currentVal = input[i];
            while (i < input.length && input[i] == currentVal) {
                i++;
            }
        }
    }

	public static void main(String[] args) {
		
		int [] input={1,2,3,4,1,2};
		printSubsets(input);

	}

}
