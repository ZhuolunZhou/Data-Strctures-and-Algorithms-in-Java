
public class AddTwoNums {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		int carryon = 0, val;
		while (l1 != null || l2 != null || carryon != 0) {
			val = carryon;
			if (l1 != null) val += l1.value;
			if (l2 != null) val += l2.value;
			carryon = val >= 10 ? 1 : 0;
			tail.next = new ListNode(val % 10);
			tail = tail.next;
		}
		return dummy.next;
	}
}
