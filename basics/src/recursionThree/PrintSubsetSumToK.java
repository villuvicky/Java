package recursionThree;

public class PrintSubsetSumToK {

	 public static void printSubsetsSumToK(int[] input, int k) {
	        printHelper(input, 0, k, "");
	    }

	    private static void printHelper(int[] input, int index, int k, String output) {

	        // Base case
	        if (index == input.length) {
	            if (k == 0) {
	                System.out.println(output.trim());
	            }
	            return;
	        }

	        // Include current element
	        printHelper(input, index + 1, k - input[index], output + input[index] + " ");

	        // Exclude current element
	        printHelper(input, index + 1, k, output);
	    }
	
	public static void main(String[] args) {
		int[] arr1= {1,2,3,4,5,6};
		printSubsetsSumToK(arr1, 6);

	}

}
