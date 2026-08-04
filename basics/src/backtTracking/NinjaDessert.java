package backtTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NinjaDessert {
	public static int closestCost(int n, int m,
			ArrayList<Integer> baseCosts,
			ArrayList<Integer> toppings,
			int target) {

		// Initialize answer with first base cost
		int[] best = new int[]{baseCosts.get(0)};

		// Try every base flavor
		for (int base : baseCosts) {
			dfs(toppings, 0, base, target, best);

			// Exact match found
			if (best[0] == target) {
				return target;
			}
		}

		return best[0];
	}

	private static void dfs(ArrayList<Integer> toppings,
			int index,
			int currentCost,
			int target,
			int[] best) {

		// Update best answer
		if (isBetter(currentCost, best[0], target)) {
			best[0] = currentCost;
		}

		// Exact match found
		if (currentCost == target) {
			return;
		}

		// All toppings processed
		if (index == toppings.size()) {
			return;
		}

		// Pruning:
		// If current cost is already greater than target and
		// farther than current best, stop exploring.
		if (currentCost > target &&
				currentCost - target > Math.abs(best[0] - target)) {
			return;
		}

		int topping = toppings.get(index);

		// Option 1: Use 0 of this topping
		dfs(toppings, index + 1, currentCost, target, best);

		// Option 2: Use 1 of this topping
		dfs(toppings, index + 1,
				currentCost + topping,
				target, best);

		// Option 3: Use 2 of this topping
		dfs(toppings, index + 1,
				currentCost + 2 * topping,
				target, best);
	}

	// Returns true if candidate is closer to target than current best.
	// If both are equally close, choose the smaller value.
	private static boolean isBetter(int candidate,
			int currentBest,
			int target) {

		int diff1 = Math.abs(candidate - target);
		int diff2 = Math.abs(currentBest - target);

		if (diff1 < diff2) {
			return true;
		}

		if (diff1 == diff2 && candidate < currentBest) {
			return true;
		}

		return false;
	}
	
	public static void main(String[] args) {

        int n = 2;
        int m = 2;

        ArrayList<Integer> baseCosts =
                new ArrayList<>(Arrays.asList(1, 7));

        ArrayList<Integer> toppings =
                new ArrayList<>(Arrays.asList(3, 4));

        int target = 10;

        int answer = closestCost(n, m, baseCosts, toppings, target);

        System.out.println(answer);   // Output: 10
    }
}
