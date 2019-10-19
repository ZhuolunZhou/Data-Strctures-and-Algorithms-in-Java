package laiOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
			public int compare(Cell c1, Cell c2) {
				if (c1.value == c2.value) {
					return 0;
				}
				return c1.value < c2.value ? -1 : 1;
			}
		});
		minHeap.offer(new Cell(0, 0, matrix[0][0]));
		boolean[][] visited = new boolean[rows][cols];
		visited[0][0] = true;
		for (int i = 0; i < k - 1; i++) {
			Cell cur = minHeap.poll();
			int curRow = cur.row;
			int curCol = cur.col;
			// check right node
			if (curCol + 1 < cols && !visited[curRow][curCol + 1]) {
				minHeap.offer(new Cell(curRow, curCol + 1, matrix[curRow][curCol + 1]));
				visited[curRow][curCol + 1] = true;
			}
			// check node below
			if (curRow + 1 < rows && !visited[curRow + 1][curCol]) {
				minHeap.offer(new Cell(curRow + 1, curCol, matrix[curRow + 1][curCol]));
				visited[curRow + 1][curCol] = true;
			}
			
		}
		return minHeap.peek().value;
	}


	class Cell {
		int value;
		int row;
		int col;
		Cell(int row, int col, int value) {
			this.row = row;
			this.col = col;
			this.value = value;
		}
	}
}
