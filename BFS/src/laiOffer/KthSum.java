package laiOffer;
import java.util.*;

public class KthSum {
	public int kthSum(int[] A, int[] B, int k) {
		Queue<Entry> minHeap = new PriorityQueue<>(k, new Comparator<Entry>() {
			@Override
			public int compare(Entry e1, Entry e2) {
				return e1.value.compareTo(e2.value);
			}
		});
		// 
		Entry cur = new Entry(0, 0, A[0] + B[0]);
		Set<Entry> visited = new HashSet<>();
		minHeap.offer(cur);
		visited.add(cur);
		// poll k times to get the kth smallest
		for (int i = 0; i < k - 1; i++) {
			cur = minHeap.poll();
			int row = cur.row;
			int col = cur.col;
			if (row + 1 < A.length) {
				Entry e = new Entry(row + 1, col, A[row + 1] + B[col]);
				if (visited.add(e)) {
					minHeap.offer(e);
				}
			}
			if (col + 1 < B.length) {
				Entry e = new Entry(row, col + 1, A[row] + B[col + 1]);
				if (visited.add(e)) {
					minHeap.offer(e);
				}
			} 
		}
		return minHeap.poll().value;
	}
	// store the index and sum in an entry
	static class Entry {
		int row;
		int col;
		Integer value;
		public Entry(int row, int col, Integer value) {
			this.row = row;
			this.col = col;
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Entry)) {
				return false;
			}
			Entry other = (Entry) obj;
			return this.row == other.row && this.col == other.col && this.value == other.value;
		}
		
		@Override
		public int hashCode() {
			return this.row * 31 * 31 + this.col * 31 + this.value.hashCode();
		}
		
	}
}
