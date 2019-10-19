package laiOffer;

public class ReorderArray {
	//	public int[] reorder(int[] array) {
	//		if (array.length <= 1) {
	//			return array;
	//		}
	//		if (array.length % 2 == 0) {
	//			helper(array, 0, array.length - 1);
	//		} else {
	//			helper(array, 0, array.length - 2);
	//		}
	//		return array;
	//	}
	//
	//	public void helper(int[] array, int left, int right) {
	//		int length = right - left + 1;
	//		if (length <= 2) {
	//			return;
	//		}
	//		int mid = left + length / 2;
	//		int leftMid = left + length / 4;
	//		int rightMid = left + length * 3 / 4;
	//		reverse(array, leftMid, mid - 1);
	//		reverse(array, mid, rightMid - 1);
	//		reverse(array, leftMid, rightMid - 1);
	//		helper(array, left, left + (leftMid - left) * 2 - 1);
	//	    helper(array, left + (leftMid - left) * 2, right);
	//	}  
	//
	//	public void reverse(int[] array, int left, int right) {
	//		while (left < right) {
	//			int temp = array[left];
	//			array[left] = array[right];
	//			array[right] = temp;
	//			left++;
	//			right--;
	//		}
	//	}
	public int[] reorder(int[] array) {
		if (array.length <= 3) {
			return array;
		}
		if (array.length % 2 == 0) {
			reorder(array, 0, array.length - 1);
		} else {
			reorder(array, 0, array.length - 2);
		}
		return array;
	}

	private void reorder(int[] array, int left, int right) {
		if (right - left <= 2) {
			return;
		}
		int size = right - left + 1;
		int l = left + size / 4;
		int m = left + size / 2;
		int r = left + size * 3 / 4;
		reverse(array, l, m - 1);
		reverse(array, m, r - 1);
		reverse(array, l, r - 1);
		int mid = l + (r - m) - 1;
		reorder(array, left, mid);
		reorder(array, mid + 1, right);
	}
	private void reverse(int[] array, int left, int right) {
		while (left < right) {
			int temp = array[left];
			array[left++] = array[right];
			array[right--] = temp;
		}
	}

}
