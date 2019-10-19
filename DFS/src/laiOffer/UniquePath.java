package laiOffer;

public class UniquePath {
//	public int uniquePaths(int m, int n) {
//		int[] count = new int[1];
//		dfs(0, 0, count, m, n);
//		return count[0];
//	}
//
//	private void dfs(int row, int col, int[] count, int m, int n) {
//		if (row == m - 1 && col == n - 1) {
//			count[0]++;
//			return;
//		} 
//		if (row + 1 < m) {
//			dfs(row + 1, col, count, m, n);
//		}
//		if (col + 1 < n) {
//			dfs(row, col + 1, count, m, n);
//		}
//	}
	public int uniquePaths(int m, int n) {
        int[][] M = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    M[i][j] = 1;
                    continue;
                } 
                M[i][j] = M[i + 1][j] + M[i][j + 1];
            }
        }
        return M[0][0];
    }
}
