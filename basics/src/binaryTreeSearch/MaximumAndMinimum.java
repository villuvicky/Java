package binaryTreeSearch;
class Pair {
	int minimum;
	int maximum;

	Pair(int min, int max) {
		this.minimum = min;
		this.maximum = max;
	}

	public class MaximumAndMinimum{

		public static Pair getMinAndMax(BinaryTreeNode<Integer> root) {

			// Base case
			if (root == null) {
				return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
			}

			// Recursive calls
			Pair left = getMinAndMax(root.left);
			Pair right = getMinAndMax(root.right);

			// Calculate min and max
			int min = Math.min(root.data, Math.min(left.minimum, right.minimum));
			int max = Math.max(root.data, Math.max(left.maximum, right.maximum));

			return new Pair(min, max);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
