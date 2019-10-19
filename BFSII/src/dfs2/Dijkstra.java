package dfs2;
import java.util.*;
public class Dijkstra {
	public void dijkstra(char[][] gym, int N, int M, int row, int col, int[][] shortestDistance) {
		Queue<Entry> minHeap = new PriorityQueue<>(new Comparator<Entry>() {
			@Override
			public int compare(Entry e1, Entry e2) {
				return e1.distance.compareTo(e2.distance);
			}
		});
		Set<Entry> expanded = new HashSet<>();
		minHeap.offer(new Entry(row, col, 0));
		while (!minHeap.isEmpty()) {
			Entry cur = minHeap.poll();
			if (expanded.add(cur)) {
				shortestDistance[cur.x][cur.y] += cur.distance;
				// top
				if (cur.x - 1 >= 0 && gym[cur.x - 1][cur.y] != 'O') {
					minHeap.offer(new Entry(cur.x - 1, cur.y, cur.distance + 1));
				}
				// bottom
				if (cur.x + 1 < N && gym[cur.x + 1][cur.y] != 'O') {
					minHeap.offer(new Entry(cur.x + 1, cur.y, cur.distance + 1));
				}
				// left
				if (cur.y - 1 >= 0 && gym[cur.x][cur.y - 1] != 'O') {
					minHeap.offer(new Entry(cur.x, cur.y - 1, cur.distance + 1));
				}
				// right
				if (cur.y + 1 < M && gym[cur.x][cur.y + 1] != 'O') {
					minHeap.offer(new Entry(cur.x, cur.y + 1, cur.distance + 1));
				}
			}
		}
	}
	
	static class Entry {
		int x, y;
		Integer distance;
		public Entry(int x, int y, Integer distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
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
			return this.x == other.x && this.y == other.y;
		}
		@Override
		public int hashCode() {
			return 31 * this.x + this.y;
		}
	}
}





