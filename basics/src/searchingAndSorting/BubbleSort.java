package searchingAndSorting;

public class BubbleSort {

	public static int bubbleSortAscending(int[] nums, int n,int k) {
	
		for (int i=0;i<n-1;i++){
			
			for(int j=0;j<n-1-i;j++) {
				
				if(nums[j]>nums[j+1]) {
					int temp=nums[j+1];
					nums[j+1]=nums[j];
					nums[j]=temp;
				}
			}
		}
		return nums[k-1];
	}
	public static int bubbleSortDscending(int[] nums, int n,int k) {
		
		for (int i=0;i<n-1;i++){
			
			for(int j=0;j<n-1-i;j++) {
				
				if(nums[j]<nums[j+1]) {
					int temp=nums[j+1];
					nums[j+1]=nums[j];
					nums[j]=temp;
				}
			}
		}
		return nums[k-1];
	}

	public static void main(String[] args) {
		int [] nums= {17,5,14,16,11,18,10};
		int n=nums.length;
		int k=5;
		
		System.out.println("Number at " +k+" place is "+ bubbleSortAscending(nums, n,  k));
		for (int i : nums) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Number at " +k+" place is "+ bubbleSortDscending(nums, n,  k));
		for (int i : nums) {
			System.out.print(i+" ");
		}
		
	}

}
