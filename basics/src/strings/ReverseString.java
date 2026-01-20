package strings;

public class ReverseString {
	
	public static void reverseString(String str) {
		
		String revString="";
		String revString2="";
		
		for(int i=str.length()-1;i>=0;i--) {
			revString = revString+str.charAt(i);
		}
		System.out.println(revString);
		

		for(int i=0;i<str.length();i++) {
			revString2 = str.charAt(i)+revString2;
		}
		System.out.println(revString2);
	}

	public static void main(String[] args) {
		String str="Vignesh";
		reverseString(str);
	}

}
