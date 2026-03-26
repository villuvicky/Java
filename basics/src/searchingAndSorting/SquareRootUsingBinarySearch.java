package searchingAndSorting;

public class SquareRootUsingBinarySearch {
	
	
	public static int search(long n) {
		
		long low=0;
		long high=n;
		 long ans = 0;
		while(low<=high) {
			
			long mid=(low+high)/2;
			
			if(mid*mid==n) {
				ans=mid;
				break;
				
			}
			
			else if(mid <= n / mid) {
				ans=mid;
				low=mid+1;
				
			}
			else {
				
				high = mid - 1;
			}
			
		}
		return (int) ans;
		
		
	}
	

	public static void main(String[] args) {
		
		long n=6;
		long m=100;
		
		//System.out.println(search(n));
		System.out.println(search(m));

	}

}
