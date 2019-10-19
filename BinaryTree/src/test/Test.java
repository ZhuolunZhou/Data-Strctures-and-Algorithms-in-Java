package test;

import java.util.List;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
//		SortedListToBST bst = new SortedListToBST();
//		TreeNode root = new TreeNode(0);
//		root.left = new TreeNode(-3);
//		root.right = new TreeNode(9);
//		root.left.left = new TreeNode(-10);
//		root.right.left = new TreeNode(5);
//		ListNode head = new ListNode(-10);
//		ListNode tail = head;
//		tail.next = new ListNode(-3);
//		tail = tail.next;
//		tail.next = new ListNode(0);
//		tail = tail.next;
//		tail.next = new ListNode(5);
//		tail = tail.next;
//		tail.next = new ListNode(9);
//		tail = tail.next;
//		bst.sortedListToBST(head);
		TreeSet<String> set = new TreeSet<>();
		set.add("acb");
		set.add("abc");
		set.add("aab");
		System.out.println(set.pollFirst());
		System.out.println(set.pollFirst());
		System.out.println(set.pollFirst());
		List<Integer> ls = null;
		for (Integer i : ls) {
			System.out.println(i);
		}
	}

}
