import java.util.*;
public class TestBench {

	public static void main(String[] args) {
//		ListNode head = new ListNode(2);
//		ListNode cur = head;
//		for (int i = 4; i <= 12; i+=2) {
//			ListNode node = new ListNode(i);
//			cur.next = node;
//			cur = cur.next;
//		}
//		Insert in = new Insert();
//		ListNode newHead = in.insert(head, 14);
//		ListNode first = new ListNode(4);
//		first.next = head;
//		head = first;
//		Delete de = new Delete();
//		ListNode newHead = de.delete(head, 4);
//		print(newHead);
//		String a = "0123";
//		System.out.println(a.substring(0, 3));
//		SortWith3Stacks s = new SortWith3Stacks();
//		LinkedList<Integer> s1 = new LinkedList<>();
//		s1.add(3);
//		s1.add(2);
//		s1.add(1);
//		s.sort(s1);
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		ReverseKNodes rk = new ReverseKNodes();
//		ListNode newHead = rk.reverse(head, 2);
//		while (newHead != null) {
//			System.out.println(newHead.value);
//			newHead = newHead.next;
//		}
		
	}
	
	public static void print(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}

}
