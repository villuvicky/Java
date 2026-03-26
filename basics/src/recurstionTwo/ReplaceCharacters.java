package recurstionTwo;

public class ReplaceCharacters {

	public static String replace(String s, char a, char b) {

		if(s.length()==0)
			return s;
		String smallInput=replace(s.substring(1), a, b);
		if(s.charAt(0)==a)
			return b+smallInput;
		else
			return s.charAt(0)+smallInput;
	}

	public static void main(String[] args) {

		System.out.println(replace("kannan", 'a', 'b'));
	}

}
