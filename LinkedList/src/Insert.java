/*
 * Given a sorted linked list and a target, insert the target to the linked list to make it still sorted
 */

public class Insert {
	public ListNode insert(ListNode head, int target) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		ListNode node = new ListNode(target);
		while (head != null) {
			if (head.value < target) {
				tail.next = head;
				tail = tail.next;
				head = head.next;
			} else {
				node.next = head;
				tail.next = node;
				return dummy.next;
			}
		}
		tail.next = node;
		return dummy.next;		
	}
}
