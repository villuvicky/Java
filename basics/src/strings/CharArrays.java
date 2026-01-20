package strings;

import java.util.Scanner;

public class CharArrays {

	public static void main(String[] args) {
		
		char[] ch={'a','b','c'};
		System.out.println(ch);//internally char are stored as it is.
		String str= "abc";//both are stored in same manner, String is a wrapper class for char and stored in pool
		System.out.println(str.charAt(0));
		String str2= new String(ch);//passing characters
		
		Scanner sc= new Scanner(System.in);
				
		String str3=sc.nextLine();
		System.out.println(str3);
		
		String str4=sc.next();
		System.out.println(str4);
		

	}

}
