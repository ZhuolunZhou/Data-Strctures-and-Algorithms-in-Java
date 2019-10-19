
public class Palindrome {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode mid = findMid(head);
		ListNode next = mid.next;
		mid.next = null;
		ListNode rightHead = reverse(next);
		return isSame(head, rightHead);
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

	private boolean isSame(ListNode one, ListNode two) {
		while (one != null && two != null) {
			if (one.value != two.value) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return true;
	}
}
