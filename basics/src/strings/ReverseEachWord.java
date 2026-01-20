package strings;

public class ReverseEachWord {

	
	public static void main(String[] args) {


		String str="Today is New Day";

		String[] subs=str.split(" ");
		String reversed="";
		
		
		
		for (String string : subs) {
			reversed=reversed+new StringBuilder(string).reverse().toString()+" ";
		}
		System.out.println(reversed);
	}

}
