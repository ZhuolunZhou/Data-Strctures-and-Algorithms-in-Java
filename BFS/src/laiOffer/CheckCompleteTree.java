package laiOffer;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompleteTree {
	public boolean isCompleted(TreeNode root) {
		if (root == null) {
			return true;
		}
		// do BFS and find whether there is a null before TreeNode
		Queue<TreeNode> queue = new LinkedList<>();
		boolean hasNull = false;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			// check left
			if (cur.left == null) {
				hasNull = true;
			} else if (hasNull) {
				return false;
			} else {
				queue.offer(cur.left);
			}
			// check right
			if (cur.right == null) {
				hasNull = true;
			} else if (hasNull) {
				return false;
			} else {
				queue.offer(cur.right);
			}
		}
		return true;
	}
}
