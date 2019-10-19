package dp;

public class LongestCommonSubString {
	public String longestCommon(String source, String target) {
		// M[i][j] represents the longest substring length of the first i characters in source and
		// first j characters in target including i, j
        int start = 0;
		int max = 0;
		for (int j = 0; j <= target.length(); j++) {
			int i = 0;
			int k = j;
			int prev = 0;
			while (i <= source.length() && k <= target.length()) {
				if (i > 0 && k > 0 && source.charAt(i - 1) == target.charAt(k - 1)) {
					prev++;
					if (prev > max) {
						max = Math.max(max, prev);
						start = i - 1 - prev + 1;
					}
				} else {
					prev = 0;
				}
				i++;
				k++;
			}
		}
		
		for (int i = 1; i <= source.length(); i++) {
			int j = 0;
			int k = i;
			int prev = 0;
			while (k <= source.length() && j <= target.length()) {
				if (j > 0 && k > 0 && source.charAt(k - 1) == target.charAt(j - 1)) {
					prev++;
					if (prev > max) {
						max = Math.max(max, prev);
						start = k - 1 - prev + 1;
					}
				} else {
					prev = 0;
				}
				k++;
				j++;
			}
		}
		return source.substring(start, start + max);
	}
}
