
public class ReverseKNodes {
	public ListNode reverse(ListNode head, int k) {
        ListNode prev = null;

        for (int i = 0; i < k; i++) {
           ListNode next = head.next;
           head.next = prev;
           prev = head;
           head = next;
        }
        return prev;
	}
}
