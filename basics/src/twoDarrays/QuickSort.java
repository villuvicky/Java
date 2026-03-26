package twoDarrays;

public class QuickSort {

	public static void quickSort(int[] arr, int low, int high) {
        // Base case
        if (low >= high) {
            return;
        }

        // Partition and get pivot index
        int p = partition(arr, low, high);

        // Recursively sort left part
        quickSort(arr, low, p - 1);

        // Recursively sort right part
        quickSort(arr, p + 1, high);
        
      
    }

	static int partition(int[] arr, int low, int high) {
	    int pivot = arr[low];
	    int i = low + 1;
	    int j = high;

	    while (i <= j) {
	        if (arr[i] <= pivot) {
	            i++;
	        } else if (arr[j] > pivot) {
	            j--;
	        } else {
	            // arr[i] > pivot && arr[j] <= pivot
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	            i++;
	            j--;
	        }
	    }

	    // place pivot at correct position
	    int temp = arr[low];
	    arr[low] = arr[j];
	    arr[j] = temp;

	    return j;
	}


    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 2};
        quickSort(arr, 0, arr.length - 1);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

}
