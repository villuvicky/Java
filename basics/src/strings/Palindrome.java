package strings;

public class Palindrome {

	public static boolean arrayMethod(String str) {
		
		int left=0;
		int right=str.length()-1;
		
		while(left<right) {
			
			if(str.charAt(left)!=str.charAt(right))
				return false;
			else {
				left++;
				right--;
				}
		}
		return true;
		
	}
	
	public static boolean inbuiltMethod(String str) {
		
		String reversed=new StringBuilder(str).reverse().toString();
		
		if( str.compareTo(reversed)==0)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		
		String str="maayalam";
		System.out.println(arrayMethod(str));
		System.out.println(inbuiltMethod(str));

	}

}
