package dp;

public class LargestSubmatrixSum {
	public int largest(int[][] matrix) {
		int N = matrix.length;
		int M = matrix[0].length;
		// prefix sum along the column
		int[][] colSum = prefixSum(matrix, N, M);
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) { // top side of submatrix
			for (int j = i; j < N; j++) { // bottom side of submatrix
				int curMax = findLargestSum(colSum[j], colSum[i], matrix[i]);
				maxSum = Math.max(maxSum, curMax);
			}
		}
		return maxSum;
	}

	private int[][] prefixSum(int[][] matrix, int N, int M) {
		int[][] result = new int[N][M];
		for (int i = 0; i < M; i++) { // cols
			for (int j = 0; j < N; j++) { // rows
				if (j == 0) {
					result[j][i] = matrix[j][i];
					continue;
				}
				result[j][i] = result[j - 1][i] + matrix[j][i];
			}
		}
		return result;
	}

	private int findLargestSum(int[] one, int[] two, int[] val) {
		int cur = one[0] - two[0] + val[0];
		int max = cur;
		for (int i = 1; i < one.length; i++) {
			int curVal = one[i] - two[i] + val[i];
			if (cur < 0) {
				cur = curVal;
			} else {
				cur += curVal;
			}
			max = Math.max(max, cur);
		}
		return max;
	}
}
