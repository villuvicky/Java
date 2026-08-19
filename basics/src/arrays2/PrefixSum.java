package arrays2;

/*
 * Q1: Given an array, build a "prefix sum" array where each index i
 * holds the sum of all elements from the start of the array up to and
 * including index i.
 *
 * Approach: the first prefix-sum value is just the first element
 * itself. Every subsequent value is the previous prefix sum plus the
 * current element: sum[i] = sum[i-1] + arr[i]. This avoids re-adding
 * everything from scratch at each index.
 *
 * NOTE: prefix sums are a common building block for other problems —
 * for example, EquilibirumIndex.java (elsewhere in this batch) uses the
 * same underlying idea (a running "leftSum") to compute left/right sums
 * in O(n) without a prefix-sum array explicitly, and PairSum.java /
 * TripletSum.java rely on sorting rather than prefix sums, but all
 * three share the general theme of avoiding repeated re-summation by
 * keeping a running total.
 *
 * Trace for arr = {1, 2, 3, 4, 5}:
 *   sum[0] = 1
 *   sum[1] = sum[0] + arr[1] = 1 + 2 = 3
 *   sum[2] = sum[1] + arr[2] = 3 + 3 = 6
 *   sum[3] = sum[2] + arr[3] = 6 + 4 = 10
 *   sum[4] = sum[3] + arr[4] = 10 + 5 = 15
 *
 * Output:
 * 1
 * 3
 * 6
 * 10
 * 15
 */
public class PrefixSum {

	public static void main(String[] args) {
		
		
		int [] arr= {1,2,3,4,5};
		int lenght=arr.length; // NOTE: minor typo — "length" is the conventional spelling
		int [] sum=new int [lenght];
		sum[0]=arr[0]; // first prefix sum is just the first element
		int start=1;
		
		while(start<lenght) {
			
			sum[start]=sum[start-1]+arr[start]; // running total, no re-summation needed
			start++;
			
		}
		for (int i : sum) {
			System.out.println(i);
		}

	}

}