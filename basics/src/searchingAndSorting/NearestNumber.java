package searchingAndSorting;

public class NearestNumber {
	public static int binarySearch(int [] nums, int target) {

		int right=nums.length-1;
		int left=0;
		if (target <= nums[0]) return 0;
		if (target >= nums[right]) return right;

		while(left<=right) {

			int mid=(right+left)/2;

			if(nums[mid]==target) {
				return mid-1;
			}
			else if(nums[mid]>target) {

				right=mid-1;
			}
			else  {
				left=mid+1;
			}
		}


		if (Math.abs(nums[left] - target) < Math.abs(nums[right] - target)) {
			return left;
		} else {
			return right;
		}
	}


	public static void main(String[] args) {

		int [] nums= {1, 3, 7, 9, 11, 12, 45};
		int target=49;
		System.out.println(binarySearch(nums, target));

	}
}
