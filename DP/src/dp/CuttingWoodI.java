package dp;

public class CuttingWoodI {
	public int minCost(int[] cuts, int length) {
		int len = cuts.length + 2;
		// M[i][j] represents the minCost of wood with cutting position from i to j
		int[][] M = new int[len][len];
		// scan from bot to top and left to right
		// i -> [0, cuts.length]
		// j -> [i + 1, cuts.length + 1]
		for (int i = cuts.length; i >= 0; i--) {
			for (int j = i + 1; j <= cuts.length + 1; j++) {
				if (j == i + 1) {   
					M[i][j] = 0;
				} else {
					M[i][j] = Integer.MAX_VALUE;
					for (int k = i + 1; k < j; k++) {
						int right = j - 1 >= cuts.length ? length : cuts[j - 1];
						int left = i - 1 < 0 ? 0 : cuts[i - 1];
						M[i][j] = Math.min(M[i][j], right - left + M[i][k] + M[k][j]);
					}
				}
			}
		}
		return M[0][cuts.length + 1];
	}
}
