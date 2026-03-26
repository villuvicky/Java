package searchingAndSorting;

public class InsertionSort {
	
	
	public static void insertionSort(int [] arr,int n) {
		
		for(int i=1;i<n;i++) {
			int temp = arr[i];
			int j=i-1;
			
			
			while(j>=0&&arr[j]>temp) {
				
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;
		}
	}
	
	

	public static void main(String[] args) {
		
		int [] nums= {17,5,14,16,11,18,10};
		int n=nums.length;
		insertionSort(nums, n);
		for (int i : nums) {
			System.out.print(i+" ");
		}

	}

}
