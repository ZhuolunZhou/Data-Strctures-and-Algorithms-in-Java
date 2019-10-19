package heap;
import java.util.*;

public class KWayMergeII {
	public ListNode merge(List<ListNode> listOfLists) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		Queue<ListNode> pq = new PriorityQueue<>(listOfLists.size(), new Comparator<ListNode>() {
			@Override
			public int compare(ListNode e1, ListNode e2) {
				if (e1.value == e2.value) return 0;
				return e1.value < e2.value ? -1 : 1;
			}
		});

		// preprocessing
		for (ListNode node : listOfLists) {
			if (node != null) {
				pq.offer(node);
			}
		}

		while (!pq.isEmpty()) {
			ListNode temp = pq.poll();
			cur.next = temp;
			cur = cur.next;
			if (temp.next != null) {
				pq.offer(temp.next);
			}
		}
		return dummy.next;
	}
}
