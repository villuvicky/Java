package searchingAndSorting;

public class MergeSortedArrays {


	public static int[] mergeSortedArrays(int arr1[],int arr2[]) {

		int len1=arr1.length;
		int len2=arr2.length;
		int len3=len1+len2;
		int arr3[]= new int[len3];
		int i=0,j=0,k=0;

		while(i<len1&&j<len2) {

			if(arr1[i]<arr2[j]) {

				arr3[k]=arr1[i];
				k++;
				i++;
			}
			else {

				arr3[k]=arr2[j];
				k++;
				j++;
			}
		}
		while(i<len1) {
			arr3[k]=arr1[i];
			k++;
			i++;

		}
		while(j<len2) {

			arr3[k]=arr2[j];
			k++;
			j++;
		}
		return arr3;
	}



	public static void main(String[] args) {

		int arr1[]= {1, 3, 4, 7, 11};
		int arr2[]= {2, 4, 6, 13};

		int arr3[]=mergeSortedArrays(arr1, arr2);

		for (int i : arr3) {
			System.out.print(i+" ");
		}


	}

}
