
public class ReOrder {
	public ListNode reorder(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode mid = findMid(head);
		ListNode next = mid.next;
		mid.next = null;
		ListNode rightHead = reverse(next);
		return merge(head, rightHead);
	}

	private ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	} 

	private ListNode merge(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (a != null && b != null) {
			tail.next = a;
			a = a.next;
			tail.next.next = b;
			b = b.next;
			tail = tail.next.next;
		}
		if (a != null) {
			tail.next = a;
		} else if (b != null) {
			tail.next = b;
		}
		return dummy.next;
	}
}
