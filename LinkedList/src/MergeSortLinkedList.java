
public class MergeSortLinkedList {

	public static void main(String[] args) {
		int[] a = new int[5];
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(2);
		ListNode newHead = mergeSort(head);
		print(newHead);
	}
	
	public static ListNode mergeSort(ListNode head) {
		// corner case
		if (head == null || head.next == null) {
	    	return head;
	    }
	    // find mid and divide list to two halves
	    ListNode mid = findMid(head);
	    ListNode next = mid.next;
	    mid.next = null; // de-link
	    
	    // sort left list and sort right list
	    ListNode left = mergeSort(head);
	    ListNode right = mergeSort(next);
	    // merge two sorted linked lists
	    ListNode newHead = merge(left, right);
	    return newHead;  
	}
	  
	// find middle point of the linked list
	private static ListNode findMid(ListNode head) {
		ListNode slow = head;
	    ListNode fast = head;
	    while (fast.next != null && fast.next.next != null) {
	      slow = slow.next;
	      fast = fast.next.next;
	    }
	    return slow;
	}
	  
	// merge two sorted linked list
	private static ListNode merge(ListNode left, ListNode right) {
	    ListNode dummy = new ListNode(0);
	    ListNode tail = dummy;
	    while (left != null && right != null) {
	    	if (left.value <= right.value) {
	    		tail.next = left;
	    		left = left.next;
	    	} else {
	    		tail.next = right;
	    		right = right.next;
	    	}
	    	tail = tail.next;
	    }
	    if (left != null) {
	    	tail.next = left;
	    }
	    if (right != null) {
	    	tail.next = right;
	    }
	    return dummy.next;
	}	 
	
	private static void print(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(""+ cur.value + " ");
			cur = cur.next;
		}
	}
}
