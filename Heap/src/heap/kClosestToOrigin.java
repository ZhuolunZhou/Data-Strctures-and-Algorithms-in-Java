package heap;
import java.util.*;

public class kClosestToOrigin {
	public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
		Set<Cell> visited = new HashSet<>();
		Queue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
			public int compare(Cell c1, Cell c2) {
				int d1 = distance(a[c1.x], b[c1.y], c[c1.z]);
				int d2 = distance(a[c2.x], b[c2.y], c[c2.z]);
				if (d1 == d2) {
					return 0;
				}
				return d1 < d2 ? -1 : 1;
			}
		});
		Cell smallest = new Cell(0, 0, 0);
		minHeap.offer(smallest);
		visited.add(smallest);
		// poll k - 1 times
		for (int i = 0; i < k - 1; i++) {
			Cell cur = minHeap.poll();
			if (cur.x + 1 < a.length) {
				Cell c1 = new Cell(cur.x + 1, cur.y, cur.z);
				if (visited.add(c1)) {
					minHeap.offer(c1);
				}	
			}
			if (cur.y + 1 < b.length) {
				Cell c2 = new Cell(cur.x , cur.y + 1, cur.z);
				if (visited.add(c2)) {
					minHeap.offer(c2);
				}	
			}
			if (cur.z + 1 < c.length) {
				Cell c3 = new Cell(cur.x , cur.y, cur.z + 1);
				if (visited.add(c3)) {
					minHeap.offer(c3);
				}	
			}
		}
		Cell cell = minHeap.peek();
		return Arrays.asList(a[cell.x], b[cell.y], c[cell.z]);
	}

	private int distance(int x, int y, int z) {
		return x * x + y * y + z * z;
	}
	static class Cell {
		int x, y, z; // index
		public Cell(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Cell)) {
				return false;
			}
			Cell other = (Cell)obj;
			return this.x == other.x && this.y == other.y && this.z == other.z;
		}
		@Override
		public int hashCode() {
			return 31 * 31 * this.x + 31 * this.y + this.z;
		}
	} 
}
