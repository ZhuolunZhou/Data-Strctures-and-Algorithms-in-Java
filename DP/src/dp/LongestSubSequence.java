package dp;

public class LongestSubSequence {
	public int longest(String source, String target) {
		// M[i][j] represents the longest subsequence length of first i letters in source 
		// and j letters in target 
		int[][] M = new int[source.length() + 1][target.length() + 1];
		for (int i = 0; i <= source.length(); i++) {
			for (int j = 0; j <= target.length(); j++) {
				if (i == 0 || j == 0) {
					M[i][j] = 0;
				} else if (source.charAt(i - 1) == target.charAt(j - 1)) {
					M[i][j] = M[i - 1][j - 1] + 1;
				} else {
					M[i][j] = Math.max(M[i][j - 1], M[i - 1][j]);
				}
			}
		}
		return M[source.length()][target.length()];
	}
}
