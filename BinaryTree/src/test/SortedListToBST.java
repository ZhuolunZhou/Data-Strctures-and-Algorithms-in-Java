package test;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}


public class SortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		ListNode mid = findMid(head);
		System.out.println(mid.val);
		TreeNode root = new TreeNode(mid.val);
		if (mid == head) {
			return root;
		}
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(mid.next);
		return root;
	}

	// 1 -> 2 -> 3 -> 4 - > null
	//     slow
	//          fast
	private ListNode findMid(ListNode head) {
		ListNode slow = head, fast = head, prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		if (prev != null) prev.next = null;
		return slow;
	}
}
