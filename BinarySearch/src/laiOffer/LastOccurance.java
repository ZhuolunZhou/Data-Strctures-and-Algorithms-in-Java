package laiOffer;

public class LastOccurance {

	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,3,5,6,7};
		int idx = lastOccurance(array, 3);
		System.out.println(idx);

	}
	
	// Time complexity: O(logn)
	// Space complexity: O(1)
	public static int lastOccurance(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		
		int left = 0;
		int right = array.length - 1;
		
		// left two elements
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] <= target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		
		// post-processing
		if (array[right] == target) {
			return right;
		} else if (array[left] == target) {
			return left;
		} else {
			return -1;
		}
	}
}
