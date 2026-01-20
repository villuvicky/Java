package strings;

public class ReverseCharArray {

	public static String stringReverse(char[] arr) {

		String str="";
		int n=arr.length;
		for(int i=n-1;i>=0;i--) {

			str=str+arr[i];
		}
		return str;
	}


	public static void main(String[] args) {

		char[] ch={'a','b','c','d'};
		System.out.println(stringReverse(ch));
	}

}
