package binaryTree;
import java.util.*;

public class PrintZigZag {
	public List<Integer> zigZag(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Deque<TreeNode> deq = new ArrayDeque<>();
		deq.offerFirst(root);
		int level = 1;
		while (!deq.isEmpty()) {
			int size = deq.size(); // number of nodes in current level
			for (int i = 0; i < size; i++) {
				// if level is odd, 左出右进
				if (level % 2 == 1) {
					TreeNode cur = deq.pollFirst();
					result.add(cur.key);
					if (cur.right != null) {
						deq.offerLast(cur.right);
					}
					if (cur.left != null) {
						deq.offerLast(cur.left);
					}
				} else { //左进右出
					TreeNode cur = deq.pollLast();
					result.add(cur.key);
					if (cur.left != null) {
						deq.offerFirst(cur.left);
					} 
					if (cur.right != null) {
						deq.offerFirst(cur.right);
					}
				}
			}
			level++;
		}
		return result;
	}
}
