package searchingAndSorting;

public class BinarySearch {
	
	public static int binarySearch(int [] nums, int target) {
		
		int right=nums.length-1;
		int left=0;
		
		while(left<=right) {
			
			int mid=(right+left)/2;
			
			if(nums[mid]==target) {
				return mid;
			}
			else if(nums[mid]>target) {
				
				right=mid-1;
			}
			else  {
				left=mid+1;
			}
		}
		
		return -1;
	}
	

	public static void main(String[] args) {
		
		 int [] nums= {1, 3, 7, 9, 11, 12, 45};
		 int target=7;
		 System.out.println(binarySearch(nums, target));

	}

}
