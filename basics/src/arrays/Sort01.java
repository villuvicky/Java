package arrays;

public class Sort01 {

	public static void sortZeroesAndOne(int[] arr) {
    	
	    int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] == 0) {
                left++;
            } 
            else if (arr[right] == 1) {
                right--;
            } 
            else {
                // arr[left] == 1 and arr[right] == 0
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
    }
		
    
	
	public static void main(String[] args) {
		
		int array[]= {0,1,1,0,1,0,1};
		sortZeroesAndOne(array);
		for (int i : array) {
			System.out.println(i);
		}

	}

}
