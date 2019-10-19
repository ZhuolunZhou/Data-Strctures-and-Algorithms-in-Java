/*
 * Given a Linked List, delete all the nodes which value is equal to target
 */
public class Delete {
	public ListNode delete(ListNode head, int target) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (head != null) {
			if (head.value != target) {
				tail.next = head;
				tail = tail.next;
			} 
			head = head.next;	
		}
		tail.next = null;
		return dummy.next;
	}
}
