package finalexam;
/*
Check if two nodes are cousins in a Binary Tree 
Given the binary Tree and the two nodes say ‘a’ and ‘b’, determine whether the two nodes are 
cousins of each other or not. 

Two nodes are cousins of each other if they are at same level and have different parents. 
 */
public class IsCousin {
	// time: O(n)  space: O(height)
	public boolean isCousin(TreeNode root, TreeNode a, TreeNode b) {
		boolean[] result = new boolean[1];
		helper(root, 0, a, b, result);
		return result[0];
	}
	
	private int helper(TreeNode root, int level, TreeNode a, TreeNode b, boolean[] result) {
		// not found 
		if (root == null) {
			return -1;
		}
		// found a or b
		if (root == a || root == b) {
			return level;
		}
		// step 1
		int left = helper(root, level + 1, a, b, result);
		int right = helper(root, level + 1, a, b, result);
		// step 2
		if (left == right && left - level > 1) {
			result[0] = true;
		}
		// step 3
		return Math.max(left, right);
	}
}

class TreeNode {
	int key;
	TreeNode left;
	TreeNode right; 
}



