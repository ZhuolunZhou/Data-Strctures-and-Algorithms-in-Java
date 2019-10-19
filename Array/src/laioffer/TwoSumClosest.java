package laioffer;
import java.util.*;
public class TwoSumClosest {
	public List<Integer> closest(int[] array, int target) {
		Queue<Node> heap = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				if (n1.val == n2.val) {
					return 0;
				}
				return Math.abs(n1.val - target) < Math.abs(n2.val - target) ? -1 : 1;
			}
		});
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				heap.offer(new Node(i, j, array[i] + array[j]));
			}
		}
		List<Integer> result = new ArrayList<>();
		Node n = heap.poll();
		result.add(array[n.row]);
		result.add(array[n.col]);
		return result;
	}

	class Node {
		int row;
		int col;
		Integer val;
		public Node(int row, int col, Integer val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}
}
