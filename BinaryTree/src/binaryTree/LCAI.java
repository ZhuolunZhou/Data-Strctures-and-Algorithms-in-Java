package binaryTree;

public class LCAI {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null || root == one || root == two) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, one, two);
		TreeNode right = lowestCommonAncestor(root.right, one, two);
		// if one subtree is null, another is not, return another
		// if both are null, return null
		if (left == null || right == null) {
			return left == null ? right : left;
		}
		return root; // root is the ancenstor
	}
}
