package dfs2;
import java.util.*;

public class DijkstraII {
	public List<Integer> putChair(char[][] gym) {
		int N = gym.length;
		int M = gym[0].length;
		int[][] cost = new int[N][M];
		List<Coordinate> equips = findEquip(gym, N, M);
		for (Coordinate e : equips) {
			dijkstra(e, gym, cost, N, M);
		}
		return findMin(cost, gym, N, M);
	}

	private List<Integer> findMin(int[][] cost, char[][] gym, int N, int M) {
		List<Integer> result = new ArrayList<>();
		result.add(-1);
		result.add(-1);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (gym[i][j] == 'C' && cost[i][j] < min) {
					min = cost[i][j];
					result.set(0, i);
					result.set(1, j);
				}
			}
		}
		return result;
	}

	private void dijkstra(Coordinate a, char[][] gym, int[][] cost, int N, int M) {
		Queue<Coordinate> minHeap = new PriorityQueue<>(new Comparator<Coordinate>(){
			@Override
			public int compare(Coordinate c1, Coordinate c2) {
				if (c1.cost == c2.cost) return 0;
				return c1.cost < c2.cost ? -1 : 1;
			}
		});
		Set<Coordinate> expanded = new HashSet<>();
		minHeap.offer(a);
		while (!minHeap.isEmpty()) {
			Coordinate cur = minHeap.poll();
			if (expanded.add(cur) && gym[cur.x][cur.y] == 'C') {
				cost[cur.x][cur.y] += cur.cost;
			}
			// left
			if (cur.y - 1 >= 0 && gym[cur.x][cur.y - 1] != 'O') {
				Coordinate left = new Coordinate(cur.x, cur.y - 1, cur.cost + 1);
				if (!expanded.contains(left)) {
					minHeap.add(left);
				}
			}
			// right
			if (cur.y + 1 < M && gym[cur.x][cur.y + 1] != 'O') {
				Coordinate right = new Coordinate(cur.x, cur.y + 1, cur.cost + 1);
				if (!expanded.contains(right)) {
					minHeap.add(right);
				}
			}
			// up
			if (cur.x - 1 >= 0 && gym[cur.x - 1][cur.y] != 'O') {
				Coordinate up = new Coordinate(cur.x - 1, cur.y, cur.cost + 1);
				if (!expanded.contains(up)) {
					minHeap.add(up);
				}
			}
			// down
			if (cur.x + 1 < N && gym[cur.x + 1][cur.y] != 'O') {
				Coordinate down = new Coordinate(cur.x + 1, cur.y, cur.cost + 1);
				if (!expanded.contains(down)) {
					minHeap.add(down);
				}
			}
		}
	}

	private List<Coordinate> findEquip(char[][] gym, int N, int M) {
		List<Coordinate> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (gym[i][j] == 'E') {
					list.add(new Coordinate(i, j, 0));
				}
			}
		}
		return list;
	}

	static class Coordinate {
		int x, y, cost;
		public Coordinate(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (!(obj instanceof Coordinate)) return false;
			Coordinate other = (Coordinate)obj;
			return this.x == other.x && this.y == other.y;
		}

		@Override
		public int hashCode() {
			return 31 * 31 * x + 31 * y;
		}
	}
}
