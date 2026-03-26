package recursionOne;

public class IsArraySorted {
	public static boolean arraySortedOrNot(int []A, int N) {
		if(A.length==1) {
			return true;
		}

		if(A[0]>A[1]) {
			return false;
		}

		int[] small = new int[A.length - 1];
		for(int i=1;i<A.length;i++) {
			small[i-1]=A[i];
		}
		return arraySortedOrNot(small, N);
	}

	public static boolean isArraySorted(int []A, int index) {

		if(index==A.length-1) {
			return true;
		}
		if(A[index]>A[index+1])
			return false;
		return isArraySorted(A, index+1);
	}

	public static void main(String[] args) {

		int []x={1,2,3,4,5};
		System.out.println(isArraySorted(x, 0));
		System.out.println(arraySortedOrNot(x, 0));

	}

}
