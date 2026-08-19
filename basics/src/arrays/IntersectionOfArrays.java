package arrays;

/*
 * Q1: Given two arrays, print their intersection — every element that
 * appears in BOTH arrays — correctly handling duplicate values (i.e. if
 * a value appears twice in both arrays, it should be counted/printed
 * twice in the intersection, not just once).
 *
 * Approach: for each element in arr1, scan arr2 looking for a match.
 * When found, print it, then "consume" that arr2 slot by overwriting it
 * with Integer.MIN_VALUE so it can never be matched again, and break
 * out of the inner loop to move on to the next arr1 element.
 *
 * IMPORTANT NOTE ON WHY THE SENTINEL VALUE MATTERS: without marking
 * matched arr2 elements as "used" (via Integer.MIN_VALUE here), the
 * SAME arr2 element could be matched multiple times against different
 * arr1 elements with the same value, over-counting the intersection.
 * This sentinel-marking technique is what makes this a correct
 * MULTISET intersection (respecting duplicate counts) rather than a
 * simple Set-based intersection (which would only care about distinct
 * values and would lose duplicate-count information).
 *
 * NOTE: Integer.MIN_VALUE is used as a "already matched" marker. This
 * assumes the input arrays never actually contain Integer.MIN_VALUE as
 * a real value — if they did, it could be incorrectly treated as an
 * already-used slot. A dedicated boolean "used" array would be a safer
 * (though slightly more verbose) alternative if that assumption can't
 * be guaranteed.
 *
 * IMPORTANT NOTE ON EFFICIENCY: this is O(n * m) — for every element in
 * arr1, it potentially scans all of arr2. For large arrays, sorting
 * both arrays first (or using a hash map of value -> remaining count)
 * would bring this down to O(n log n) or O(n + m).
 *
 * Trace for arr1 = {2, 6, 1, 2}, arr2 = {1, 2, 3, 4, 2}:
 *   arr1[0]=2 -> matches arr2[1]=2 -> print 2, arr2 becomes {1, MIN, 3, 4, 2}
 *   arr1[1]=6 -> no match found in arr2
 *   arr1[2]=1 -> matches arr2[0]=1 -> print 1, arr2 becomes {MIN, MIN, 3, 4, 2}
 *   arr1[3]=2 -> matches arr2[4]=2 -> print 2, arr2 becomes {MIN, MIN, 3, 4, MIN}
 *
 * Output:
 * 2
 * 1
 * 2
 */
public class IntersectionOfArrays {

	public static void intersections(int arr1[], int arr2[]) {

		for(int i=0;i<arr1.length;i++) {

			for(int j=0;j<arr2.length;j++) {

				if(arr1[i]==arr2[j]) {
					System.out.println(arr1[i]);
					arr2[j] = Integer.MIN_VALUE; // marks this slot as "used" so it can't be matched again
					break;
				}
			}
		}
	}
	public static void main(String[] args) {

		int arr1 []= {2, 6, 1, 2};
		int arr2[]= {1, 2, 3, 4, 2};
		intersections(arr1, arr2);

	}

}