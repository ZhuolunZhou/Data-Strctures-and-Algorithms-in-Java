package sort;
import java.util.*;

public class CountArray {
	public int[] countArray(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		// key: element  value: number of smaller integers on the right
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : array) {
			map.put(i, 0);
		}
		int[] helper = new int[array.length];
		int[] newArr = Arrays.copyOf(array, array.length);
		mergeSort(newArr, 0, newArr.length - 1, helper, map);
		int[] result = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			result[i] = map.get(array[i]);
		}
		return result;
	}

	private void mergeSort(int[] array, int left, int right, 
			int[] helper, Map<Integer, Integer> map) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(array, left, mid, helper, map);
		mergeSort(array, mid + 1, right, helper, map);
		for (int i = left; i <= right; i++) {
			helper[i] = array[i];
		}
		int leftBound = left;
		int rightBound = mid + 1;
		// combine and record
		while (leftBound <= mid && rightBound <= right) {
			if (helper[leftBound] <= helper[rightBound]) {
				array[left++] = helper[leftBound];
				int num = map.get(helper[leftBound]);
				map.put(helper[leftBound], rightBound - (mid + 1) + num);
				leftBound++;
			} else {
				array[left++] = helper[rightBound++];
			}
		}
		while (leftBound <= mid) {
			array[left++] = helper[leftBound];
			int num = map.get(helper[leftBound]);
			map.put(helper[leftBound], rightBound - (mid + 1) + num);
			leftBound++;
		}
	}
}
