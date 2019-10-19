package heap;
import java.util.*;

public class KWayMerge {
	public int[] merge(int[][] arrayOfArrays) {
		int k = arrayOfArrays.length;
		Queue<Pointer> minHeap = new PriorityQueue<>(k, new Comparator<Pointer>() {
			@Override
			public int compare(Pointer one, Pointer two) {
				if (one.value == two.value) return 0;
				return one.value < two.value ? -1 : 1;
			}
		});
		// preprocess, put first element of each array to pq
		int totalLen = 0;
		for (int i = 0; i < k; i++) {
			int[] cur = arrayOfArrays[i];
			totalLen += cur.length;
			if (cur.length != 0) {
				minHeap.offer(new Pointer(cur[0], i, 0));
			}
		}
		int[] result = new int[totalLen];
		int i = 0;  // record the index of result
		while (!minHeap.isEmpty()) {
			Pointer cur = minHeap.poll();
			result[i++] = cur.value;
			int arrayIdx = cur.arrayIdx;
			int idx = cur.idx;
			int len = arrayOfArrays[arrayIdx].length;
			if (idx + 1 < len) {
				minHeap.offer(new Pointer(arrayOfArrays[arrayIdx][idx + 1], arrayIdx, idx + 1));
			}
		}
		return result;
	}


	static class Pointer {
		int arrayIdx;
		int idx;
		int value;
		public Pointer(int value, int arrayIdx, int idx) {
			this.value = value;
			this.arrayIdx = arrayIdx;
			this.idx = idx;
		}
	}
}
