package dp;

public class NumOfLongestIncreasingSubsequence {
	public int findNumberOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		// M[i] represents the longest increasing subsequence from 0 to i including i
		int[] M = new int[nums.length];
		int longest = 1, count = 0;
		for (int i = 0; i < nums.length; i++) {
			M[i] = 1;
			int tmp = 1; // record the duplicate numbers 
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					M[i] = Math.max(M[i], M[j] + 1);
				}
				if (M[i] > longest) {
					longest = M[i];
					tmp = 1;
				} else if (M[i] == longest) {
					tmp++;
				}
			}
			count = tmp;
		}
		return count;
	}
}
