package recurstionTwo;

public class BinarySearch {
	
	public static int binarySearch(int input[], int element) {
		int si=0;
		int ei=input.length-1;
		return helper(input,si, ei, element);

	}

	public static int helper(int input[],int si, int ei, int x) {
		
		if(si>ei)
			return -1;
		
		int mid=(si+ei)/2;
		
		if(input[mid]==x)
		return mid;
		
		else if(input[mid]>x)
			return helper(input, si, mid-1, x);
		else
			return helper(input,mid+1,ei,x);
			
	}
	
	public static void main(String[] args) {
		
		 int [] nums= {1, 3, 7, 9, 11, 12, 45};
		 int target=1;
		 System.out.println(binarySearch(nums, target));

	}

}
