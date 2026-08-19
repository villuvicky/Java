package arrays;

/*
 * Q1: Given an array containing only 0s and 1s, sort it in-place so
 * that all 0s come before all 1s — WITHOUT using any extra array or a
 * separate counting pass — in a single O(N) scan.
 *
 * Approach (two-pointer / Dutch National Flag style): maintain a
 * "left" pointer starting at the beginning and a "right" pointer
 * starting at the end.
 *   - If arr[left] is already 0, it's already in the right place ->
 *     move left forward.
 *   - If arr[right] is already 1, it's already in the right place ->
 *     move right backward.
 *   - Otherwise, arr[left] must be 1 and arr[right] must be 0 (both
 *     out of place relative to each other) -> swap them, then move
 *     both pointers inward.
 * Continue until left and right meet.
 *
 * NOTE ON WHY THIS WORKS IN ONE PASS: at every step, at least one of
 * the three conditions is guaranteed to be true (since every element is
 * either 0 or 1), so exactly one pointer move (or one swap + two
 * pointer moves) happens per iteration — the pointers always move
 * toward each other, guaranteeing termination in O(N) time and O(1)
 * extra space (all swapping happens in-place on the original array).
 *
 * Trace for arr = {0, 1, 1, 0, 1, 0, 1} (left=0, right=6):
 *   arr[left]=0        -> left++            (left=1)
 *   arr[right]=1       -> right--            (right=5)
 *   arr[left]=1, arr[right]=0 -> swap -> {0,0,1,0,1,1,1}, left++ right-- (left=2, right=4)
 *   arr[right]=1       -> right--            (right=3)
 *   arr[left]=1, arr[right]=0 -> swap -> {0,0,0,1,1,1,1}, left++ right-- (left=3, right=2)
 *   left(3) < right(2)? false -> loop ends
 *
 * Output:
 * 0
 * 0
 * 0
 * 1
 * 1
 * 1
 * 1
 */
public class Sort01 {

	public static void sortZeroesAndOne(int[] arr) {
    	
	    int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] == 0) {
                left++; // already in correct place on the left side
            } 
            else if (arr[right] == 1) {
                right--; // already in correct place on the right side
            } 
            else {
                // arr[left] == 1 and arr[right] == 0 -> both out of place, swap them
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
    }
		
    
	
	public static void main(String[] args) {
		
		int array[]= {0,1,1,0,1,0,1};
		sortZeroesAndOne(array);
		for (int i : array) {
			System.out.println(i);
		}

	}

}