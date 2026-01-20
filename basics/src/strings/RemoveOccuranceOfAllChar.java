package strings;

public class RemoveOccuranceOfAllChar {

	public static String removeOccuranceOfAllChar(String str,char ch) {
		StringBuilder result = new StringBuilder();
		for(int i=0;i<str.length();i++) {

			if(str.charAt(i)!=ch) {
				result.append(str.charAt(i));
			}
		}
		return	result.toString();

	}

	public static void main(String[] args) {

		String str="aabccbaa";
		char ch='a';
		System.out.println(removeOccuranceOfAllChar(str,ch));
	}
}
