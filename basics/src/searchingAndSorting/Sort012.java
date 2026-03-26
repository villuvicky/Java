package searchingAndSorting;

public class Sort012 {
	
	public static void sort012(int[] arr, int n) {
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                // swap arr[low] and arr[mid]
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else { // arr[mid] == 2
                // swap arr[mid] and arr[high]
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;
            }
        }
	}
	public static void main(String[] args) {
		int [] nums= {0, 1, 2, 0, 2, 0, 1};
		int n=nums.length;
		
		sort012(nums, n);
	}

}
