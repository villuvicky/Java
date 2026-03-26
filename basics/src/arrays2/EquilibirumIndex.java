package arrays2;

public class EquilibirumIndex {
	public static int equilibriumIndex(int[] arr) {
	    int totalSum = 0;

	    for (int num : arr) {
	        totalSum += num;
	    }

	    int leftSum = 0;

	    for (int i = 0; i < arr.length; i++) {
	        int rightSum = totalSum - leftSum - arr[i];

	        if (leftSum == rightSum) {
	            return i;
	        }

	        leftSum += arr[i];
	    }

	    return -1;
	}


	public static void main(String[] args) {
		
		System.out.println(equilibriumIndex(new int []{1,4,9,3,2}));

	}

}
