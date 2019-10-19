package laiOffer;
import java.util.*;

public class NQueens {
	public List<List<Integer>> nqueens(int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		boolean[] cols = new boolean[n];
		boolean[] upperDiagonal = new boolean[2 * n - 1];
		boolean[] downDiagonal = new boolean[2 * n - 1];
		findNqueens(n, cur, cols, upperDiagonal, downDiagonal, result);
		return result;
	}

	private void findNqueens(int n, List<Integer> cur, boolean[] cols, boolean[] upperDiagonal,
			boolean[] downDiagonal, List<List<Integer>> result) {
		if (cur.size() == n) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i = 0; i < n; i++) { // i is current col index
			int row = cur.size();
		if (isValid(n, cols, upperDiagonal, downDiagonal, row, i)) {
			mark(n, cur, cols, upperDiagonal, downDiagonal, row, i);
			findNqueens(n, cur, cols, upperDiagonal, downDiagonal, result);
			unmark(n, cur, cols, upperDiagonal, downDiagonal, row, i);
		}
		} 
	}

	private boolean isValid(int n, boolean[] cols, boolean[] upperDiagonal, 
			boolean[] downDiagonal, int row, int curCol) {
		if (cols[curCol] || upperDiagonal[curCol + row] || downDiagonal[curCol - row + n - 1]) {
			return false;
		}
		return true;
	}

	private void mark(int n, List<Integer> cur, boolean[] cols, boolean[] upperDiagonal, 
			boolean[] downDiagonal, int row, int curCol) {
		cur.add(curCol);
		cols[curCol] = true;
		upperDiagonal[curCol + row] = true;
		downDiagonal[curCol - row + n - 1] = true;
	}

	private void unmark(int n, List<Integer> cur, boolean[] cols, boolean[] upperDiagonal, 
			boolean[] downDiagonal, int row, int curCol) {
		cur.remove(cur.size() - 1);
		cols[curCol] = false;
		upperDiagonal[curCol + row] = false;
		downDiagonal[curCol - row + n - 1] = false;
	}              
}
