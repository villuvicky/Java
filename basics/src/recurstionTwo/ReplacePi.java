package recurstionTwo;

public class ReplacePi {
	
	
	public static String replcae(String s) {
		
		if(s.length()<=1) {
			
			return s;
		}
		
		if(s.charAt(0)=='p'&&s.charAt(1)=='i') {
			
			String smallOutput=replcae(s.substring(2));
			return 3.14+smallOutput;
		}
		else
		{
			
			String smallOutput=replcae(s.substring(1));
			return s.charAt(0)+smallOutput;
		}
		
		
	}
	
	

	public static void main(String[] args) {
		
		String value="apipiapia";
		System.out.println(replcae(value));

	}

}
