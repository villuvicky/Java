package recursionOne;

public class RemoveX {
	
	
	public static String remove(String s) {
		
		if(s.length()==0)
			return "";
		String s2=remove(s.substring(1));
		if(s.charAt(0)=='x')
			return s2;
		else
			return s.charAt(0)+s2;
	}
	

	public static void main(String[] args) {
	
		System.out.println(remove("pxxxxxfxxp"));
	}

}
