package laiOffer;
// time: O(logn + logk)   space: O(logk)
public class kClosest {
	public int kth(int[] array, int target, int k) {
		int left = largestNotLarger(array, target);
		return helper(array, left, left + 1, k, target);
	}
	
	private int largestNotLarger(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] <= target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		// post-processing
		if (array[right] <= target) {
			return right;
		} else if (array[left] <= target) {
			return left;
		}
		return -1;
	}
	
	private int helper(int[] array, int aIdx, int bIdx, int k, int target) {
		if (aIdx < 0) {
			return array[bIdx + k - 1];
		}
		if (bIdx >= array.length) {
			return array[aIdx - k + 1];
		}
		if (k == 1) {
			return target - array[aIdx] <= array[bIdx] - target ? array[aIdx] : array[bIdx];
		}
		int aMid = aIdx - k / 2 + 1;
		int bMid = bIdx + k / 2 - 1;
		
		int aVal = aMid < 0 ? Integer.MAX_VALUE : target - array[aMid];
		int bVal = bMid >= array.length ? Integer.MAX_VALUE : array[bMid] - target;
		
		if (aVal <= bVal) {
			return helper(array, aMid - 1, bIdx, k - k / 2, target);
		} else {
			return helper(array, aIdx, bMid + 1, k - k / 2, target);
		}
	}
}








