package binaryTree;

//class TreeNode {
//	public int key;
//	public TreeNode left;
//	public TreeNode right;
//	public TreeNode(int key) {
//		this.key = key;
//	}
//}

public class DeleteBST {
	public TreeNode deleteTree(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		// find target
		if (root.key > key) {
			root.left = deleteTree(root.left, key);
			return root;
		} else if (root.key < key) {
			root.right = deleteTree(root.right, key);
			return root;
		}
		// root is the target
		// case 1: root.left == null && root.right == null
		// case 2: root.left == null && root.right != null
		// case 3: root.right == null && root.left == null
		if (root.left == null) {
			return root.right;
		} else if (root.right == null) {
			return root.left;
		}

		if (root.right.left == null) {
			root.right.left = root.left;
			return root.right;
		}
		
		TreeNode largest = deleteLargest(root.left); // find the rightmost TreeNode of the left subtree
		largest.left = root.left;
		largest.right = root.right;
		return largest;
	}

	private TreeNode deleteLargest(TreeNode root) {
		TreeNode prev = null;
		while (root.right != null) {
			prev = root;
			root = root.right;
		}
		prev.right = prev.right.left;
		return root;
	}
}
