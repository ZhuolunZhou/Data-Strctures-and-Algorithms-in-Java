package dp;

public class LongestAscendingSubSequence {
	public int longest(int[] array) {
		if (array.length == 0) return 0;
		// M[i] represents the longest ascending subsequence length ends at index i
		int[] helper = new int[array.length + 1]; // index: M[i]  helper[i]: corresponding array value
		int longest = 1;
		helper[1] = array[0];
		for (int i = 1; i < array.length; i++) {
			int index = findLargestSmaller(helper, array[i], 1, longest);
			if (index == -1) { // array[i] is the smallest element
				helper[1] = Math.min(helper[1], array[i]);
			} else if (index == longest){
				helper[++longest] = array[i];
			} else if (array[i] < helper[index + 1]) {
				helper[index + 1] = array[i];
			}
		}
		return longest;
	}
	
	private int findLargestSmaller(int[] array, int target, int left, int right) {
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (array[mid] >= target) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		if (array[right] < target) {
			return right;
		} else if (array[left] < target) {
			return left;
		}
		return -1;
	}
}
