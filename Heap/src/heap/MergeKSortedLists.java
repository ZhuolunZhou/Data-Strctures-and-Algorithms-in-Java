package heap;
import java.util.*;

public class MergeKSortedLists {
	public ListNode merge(List<ListNode> listOfLists) {
		// corner case
		if (listOfLists == null || listOfLists.size() == 0) {
			return null;
		}
		Queue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
			public int compare(ListNode n1, ListNode n2) {
				if (n1.value == n2.value) {
					return 0;
				}
				return n1.value < n2.value ? -1 : 1;
			}
		});
		ListNode dummy = new ListNode(0);
		ListNode temp = dummy;
		// put k heads into minheap
		for (ListNode node : listOfLists) {
			if (node != null) {
				minHeap.offer(node);
			}
		}
		while (!minHeap.isEmpty()) {
			ListNode node = minHeap.poll();
			temp.next = node;
			temp = temp.next;
			if (node.next != null) {
				minHeap.offer(node.next);
			}
		}
		temp.next = null;
		return dummy.next;
	}
}

class ListNode {
	int value;
	ListNode next;
	public ListNode(int value) {
		this.value = value;
	}
}







