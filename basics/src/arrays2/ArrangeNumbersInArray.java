package arrays2;

public class ArrangeNumbersInArray {
	

	public static void arrange(int [] arrange,int n) {
		
		
		int index=0;
		for(int i=1;i<=n;i+=2) {
			arrange[index++]=i;
			
		}
		 for (int i = (n % 2 == 0 ? n : n - 1); i >= 2; i -= 2) {
			 arrange[index++] = i;
	        }
		
	}
	
	public static void main(String[] args) {
		int [] arrange= new int[10];
		int n=arrange.length;
		arrange(arrange, n);
		for (int i : arrange) {
			System.out.print(i+" ");
		}

	}

}
