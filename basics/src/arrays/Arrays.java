package arrays;

public class Arrays {

	public static void main(String[] args) {
		
		int arr[];
		
		int [] arr2;
		
		arr= new int[5];
		arr[0]=1;
		int[] arr1= {1,2,3,4,5,6};
		for(int i=0;i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
		System.out.println();
		System.out.println();
		for (int i : arr1) {
		
			System.out.println(i);
		}

	}

}
