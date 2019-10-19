package laiOffer;

public class ClassicalBinarySearch {

	public static void main(String[] args) {
		// test case
		int[] array = new int[] {1,2,3,4,5,6,7};
		int idx = binarySearch(array, 5);
		System.out.println(idx);
	}
	
	// Time complexity: O(logn)
	// Space complexity: O(1)
	public static int binarySearch(int[] array, int target) {
		// corner case
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		
		// <= because when there is only one element, we still need to check whether it is target
		while (left <= right) { 
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid + 1; // + 1 to avoid dead loop
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

}
