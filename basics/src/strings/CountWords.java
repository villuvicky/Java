package strings;

public class CountWords {



	public static void charMethod(String str) {

		int n=str.length();
		int count=0;
		for(int i=0;i<n;i++) {
			if(str.charAt(i)==' ')
				count++;
		}
		count++;
		System.out.println(count);
	}
	
	public static void main(String[] args) {

		String str="this is a sample string";
		charMethod(str);
		
		String[] splt=str.split(" ");
		System.out.println(splt.length);
	}

}
