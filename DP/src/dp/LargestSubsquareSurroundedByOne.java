package dp;

public class LargestSubsquareSurroundedByOne {
	public int largest(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int N = matrix.length;
		int M = matrix[0].length;
		return helper(matrix, N, M);
	}	
	
	private int helper(int[][] matrix, int N, int M) {
		int[][] rl = new int[N][M];
		int[][] bu = new int[N][M];
		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					if (j == M - 1 || rl[i][j + 1] == 0) {
						rl[i][j] = 1;
					} else {
						rl[i][j] = rl[i][j + 1] + 1;
					}
					if (i == N - 1 || bu[i + 1][j] == 0) {
						bu[i][j] = 1;
					} else {
						bu[i][j] = bu[i + 1][j] + 1;
					}
				}
			}
		}
		return merge(rl, bu, N, M);
	}
	
	private int merge(int[][] rl, int[][] bu, int N, int M) {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int min = Math.min(rl[i][j], bu[i][j]);
				if (min > 0) {
					for (int k = min; k >= 0; k--) {
						if (i + k - 1 < N && j + k - 1 < M) {
							int temp = Math.min(rl[i + k - 1][j], bu[i][j + k - 1]);
							if (temp >= k) {
								max = Math.max(max, k); // record the current max length;
								break;
							} 
						} 
					}
				}
			}
		}
		return max;
	}
}






