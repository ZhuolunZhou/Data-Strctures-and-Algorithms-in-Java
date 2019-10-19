package leetcode;

public class MostStonesRemoved {
	
	class DSU {
		private int[] root, rank;
		private int count, size;
		public DSU(int size) {
			this.size = size;
			root = new int[size];
			for (int i = 0; i < size; i++) {
				root[i] = i;
			}
			rank = new int[size];
			count = size;
		}
		
		private int find(int x) {
			if (root[x] != x) {
				root[x] = find(root[x]);
			}
			return root[x];
		}
		
		private void union(int x, int y) {
			int xp = find(x), yp = find(y);
			if (xp == yp) return;
			if (rank[xp] < rank[yp]) {
				root[xp] = yp;
			} else if (rank[xp] > rank[yp]) {
				root[yp] = xp;
			} else {
				root[xp] = yp;
				rank[yp]++;
			}
			count--;
		}
	}
	
	
	public int removeStones(int[][] stones) {
		DSU dsu = new DSU(stones.length);
		for (int i = 0; i < stones.length; i++) {
			for (int j = i + 1; j < stones.length; j++) {
				if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
					dsu.union(i, j);
				}
			}
		}
		return stones.length - dsu.count;
	}
}
