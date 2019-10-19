package recursion;

public class RotateMatrix {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		int N = matrix.length;
		rotate(matrix, N, 0, 0);
	}
	// (x,y) is the upper-left corner coordinate
	private void rotate(int[][] matrix, int N, int x, int y) {
		if (N <= 1) {
			return;
		}
		// bottom-left coordinate(x + N - 1, y);
		// bottom-right coordinate (x + N - 1, y + N - 1)
		// top-right coordinate (x, y + N - 1)
		for (int i = 0; i < N - 1; i++) {
			int tmp = matrix[x][y + i];
			matrix[x][y + i] = matrix[x + N - 1 - i][y];
			matrix[x + N - 1 - i][y] = matrix[x + N - 1][y + N - 1 - i]; 
			matrix[x + N - 1][y + N - 1 - i] = matrix[x + i][y + N - 1];
			matrix[x + i][y + N - 1] = tmp;
		}
		rotate(matrix, N - 2, x + 1, y + 1);
	}
}
