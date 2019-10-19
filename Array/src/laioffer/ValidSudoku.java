package laioffer;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		int N = board.length;
		int n = board.length / 3;
		int[] cols = new int[N];
		int[] subBox = new int[N];
		for (int i = 0; i < N; i++) {
			int row = 0; // records the digits on a row
			for (int j = 0; j < N; j++) {
				char c = board[i][j];
				if (c != '.') {
					// ith row, jth col
					int shift = c - '0';
					if ((row >> shift & 1) == 1 || (cols[j] >> shift & 1) == 1 || 
							(subBox[i / n * n + j / n] >> shift & 1) == 1) {
						return false;
					}
					row |= 1 << shift;
					cols[j] |= 1 << shift;
					subBox[i / n * n + j / n] |= 1 << shift;
				}
			}
		}
		return true;
	}
}
