package binaryTree;

public class MaxPathSumI {
	public int maxPathSum(TreeNode root) {
		if (root == null || root.left == null && root.right == null) {
			return Integer.MIN_VALUE;
		}
		int[] globalMax = new int[]{Integer.MIN_VALUE};
		helper(root, globalMax);
		return globalMax[0];
	}

	// return the maximum path sum from leaf to root (including root)
	private int helper(TreeNode root, int[] globalMax) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int left = helper(root.left, globalMax);
		int right = helper(root.right, globalMax);
		// update globalMax if root has two children
		if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE) {
			globalMax[0] = Math.max(globalMax[0], root.key + left + right);
		}
		if (left == Integer.MIN_VALUE && right == Integer.MIN_VALUE) { // leaf node
			return root.key;
		} else {
			return Math.max(left, right) + root.key;
		}
	}
}
