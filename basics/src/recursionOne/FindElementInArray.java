package recursionOne;

public class FindElementInArray {
	
	public static boolean find(int input[], int x) {
		
		if(input.length==0) {
			return false;
		}
		
		if(input[0]==x) {
			return true;
		}
		
		 int[] small = new int[input.length - 1];
		 for(int i=1;i<input.length;i++) {
			 small[i-1]=input[i];
		 }
		 return find(small, x);
	}
	
	static boolean checkNumberHelper(int[] input, int x, int index) {

	    // base case: end of array
	    if (index == input.length)
	        return false;

	    // check current element
	    if (input[index] == x)
	        return true;

	    // move to next index
	    return checkNumberHelper(input, x, index + 1);
	}

	public static void main(String[] args) {
		int []x={1,2,3,4,5};
		System.out.println(find(x,554));
		System.out.println(checkNumberHelper(x, 4, 0));
	}

}
