package recurstionTwo;

public class RemoveConsDuplicate {
	
	
	public static String remove(String s, int index) {
		
		if (index == s.length() - 1) {
            return s.charAt(index) + "";
        }
		String smallAns = remove(s, index + 1);
		System.out.println(smallAns);
		if (s.charAt(index) == smallAns.charAt(0)) {
            return smallAns;
        } else {
            return s.charAt(index) + smallAns;
        }
	}
	
	

	public static void main(String[] args) {
		
		System.out.println(remove("aabccb", 0));

	}

}
