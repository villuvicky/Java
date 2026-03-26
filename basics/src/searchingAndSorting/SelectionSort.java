package searchingAndSorting;

public class SelectionSort {

	public static int selectionSortAscending(int[] nums, int n,int k) {

		for (int i=0;i<=n;i++){

			for(int j=i+1;j<n;j++) {

				int min=nums[i];
				if(nums[j]<min) {
					int temp=nums[j];
					nums[j]=nums[i];
					nums[i]=temp;
					min=nums[j];
				}
			}
		}
		return nums[k-1];
	}
	public static int selectionSortDscending(int[] nums, int n,int k) {

		for (int i=0;i<=n;i++){

			for(int j=i+1;j<n;j++) {

				int min=nums[i];
				if(nums[j]>min) {
					int temp=nums[j];
					nums[j]=nums[i];
					nums[i]=temp;
					min=nums[j];
				}
			}
		}
		return nums[k-1];
	}


	public static int sumOfWrongOrder(int[] arr) {
		int sum = 0;
		int n=arr.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;

			// find index of minimum element
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}

			// if swap needed
			if (minIndex != i) {
				sum += (minIndex - i);

				// swap
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int [] nums= {17,5,14,16,11,18,10};
		int n=nums.length;
		int k=5;
		selectionSortDscending(nums, n, k);
		for (int i : nums) {
			System.out.print(i+" ");
		}
		System.out.println();
		selectionSortAscending(nums, n, k);
		for (int i : nums) {
			System.out.print(i+" ");
		}

		System.out.println();
		int [] num2= {3, 2, 11, 5, 1};
		System.out.println(sumOfWrongOrder(num2));

	}

}
