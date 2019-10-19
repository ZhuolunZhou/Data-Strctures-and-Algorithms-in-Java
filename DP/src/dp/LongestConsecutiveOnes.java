package dp;

public class LongestConsecutiveOnes {
	public int longest(int[] array) {
		int prev = 0;
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				prev = 0;
			} else {
				prev++;;
				Math.max(max, prev);
			}
		}
		return max;
	}
}
