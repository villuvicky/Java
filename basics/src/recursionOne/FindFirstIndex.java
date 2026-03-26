package recursionOne;

public class FindFirstIndex {
	
	
	
public static int findX(int input[], int x) {
		
	return find(input, x, 0);
	}
	
	
	
	public static int find(int [] arr, int x, int index) {
		
		if(arr.length-1<index) {
			return -1;
		}
		if(arr[0]==x)
			return 0;
		
		if(arr[index]==x)
			return index;

		
		return find(arr, x, index+1);
		
	}
	
	
	

	public static void main(String[] args) {
		
		int []x={1,2,3,4,5};
		
		System.out.println(find(x, 44, 0));
		
		System.out.println(findX(x, 5));
	}

}
