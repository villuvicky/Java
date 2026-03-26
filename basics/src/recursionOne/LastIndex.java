package recursionOne;

public class LastIndex {
	
	public static int lastIndex(int input[], int x) {
		return last(input,x, input.length);
	}

	 static int last(int[] input, int x, int length) {
		
		 if(length<=0)
			 return -1;
		 if(input[length-1]==x)
			 return length-1;
		 
		 return last(input, x, length-1);
		 
	
	}

	public static void main(String[] args) {
		int []arr={1,2,2,4,2};
		System.out.println(lastIndex(arr, 22));
	}

}
