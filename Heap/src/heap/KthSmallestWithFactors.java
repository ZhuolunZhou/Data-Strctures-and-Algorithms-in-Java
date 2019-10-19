package heap;
import java.util.*;

public class KthSmallestWithFactors {
	public long kth(int k) {
		Queue<Long> minHeap = new PriorityQueue<>(k);
		Set<Long> set = new HashSet<>();
		minHeap.offer(3 * 5 * 7L);
		set.add(3 * 5 * 7L);
		for (int i = 0; i < k - 1; i++) {
			long cur = minHeap.poll();
			if (set.add(cur * 3)) {
				minHeap.offer(cur * 3);
			}    
			if (set.add(cur * 5)) {
				minHeap.offer(cur * 5);
			}
			if (set.add(cur * 7)) {
				minHeap.offer(cur * 7);
			}
		}
		return minHeap.peek();
	}
}
