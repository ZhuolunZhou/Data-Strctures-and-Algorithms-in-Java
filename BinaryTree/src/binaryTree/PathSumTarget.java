package binaryTree;

import java.util.HashMap;
import java.util.Map;

public class PathSumTarget {
	public boolean exist(TreeNode root, int target) {
		if (root == null) {
			return false;
		}
		Map<Integer, Integer> prefixSum = new HashMap<>();
		prefixSum.put(0, 1);
		return helper(root, target, 0, prefixSum);
	}

	private boolean helper(TreeNode root, int target, int preSum, Map<Integer, Integer> prefixSum) {
		if (root == null) {
			return false;
		}
		preSum += root.key;
		Integer num = prefixSum.get(preSum - target);
		if (num != null && num > 0) {
			return true;
		} 
		prefixSum.put(preSum, prefixSum.getOrDefault(preSum, 0) + 1);
		if (helper(root.left, target, preSum, prefixSum) || helper(root.right, target, preSum, prefixSum)) {
			return true;
		}
		prefixSum.put(preSum, prefixSum.get(preSum) - 1);
		return false;
	}
}

