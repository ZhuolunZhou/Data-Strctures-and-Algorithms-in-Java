package dp;

public class longestCross {
	public int largest(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		// preprocessing 
		int N = matrix.length;
		int M = matrix[0].length;
		int[][] lu = leftUp(matrix, N, M);
		int[][] rd = rightDown(matrix, N, M);
		// find the globalMax
		return merge(lu, rd);
	}

	// scan the matrix from left to right, up to bottom
	private int[][] leftUp(int[][] matrix, int N, int M) {
		int[][] left = new int[N][M];
		int[][] up = new int[N][M];
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == 1) {
					// update consecutive ones from left to right
					if (j == 0 || left[i][j - 1] == 0) {
						left[i][j] = 1;
					} else {
						left[i][j] = left[i][j - 1] + 1;
					}
					// update consectutive ones from up to bottom
					if (i == 0 || up[i - 1][j] == 0) {
						up[i][j] = 1;
					} else {
						up[i][j] = up[i - 1][j] + 1;
					}
				} 
			}
		}
		merge(left, up);
		return left;
	}

	// scan the matrix from right to left, bottom to up
	private int[][] rightDown(int[][] matrix, int N, int M) {
		int[][] right = new int[N][M];
		int[][] bottom = new int[N][M];
		for (int i = N - 1; i >= 0; i--) { 
			for (int j = M - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					// update consecutive ones from right to left
					if (j == M - 1 || right[i][j + 1] == 0) {
						right[i][j] = 1;
					} else {
						right[i][j] = right[i][j + 1] + 1;
					}
					// update consectutive ones from bottom to up
					if (i == N - 1 || bottom[i + 1][j] == 0) {
						bottom[i][j] = 1;
					} else {
						bottom[i][j] = bottom[i + 1][j] + 1;
					}
				} 
			}
		}
		merge(right, bottom);
		return right;
	}

	// get the longest cross length
	private int merge(int[][] one, int[][] two) {
		int row = one.length;
		int col = one[0].length;
		int max = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				one[i][j] = Math.min(one[i][j], two[i][j]);
				max = Math.max(max,  one[i][j]);
			}
		}
		return max;
	}
}
