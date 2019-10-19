package sort;
import java.util.*;

public class GetCountArray {
	public int[] countArray(int[] array) {
		if (array == null || array.length == 0) return array;
		Entry[] arr = convert(array);
		Entry[] helper = new Entry[arr.length];
		mergeSort(arr, 0, arr.length - 1, helper);
		Map<Integer, Integer> map = getMap(arr);
		int[] result = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			result[i] = map.get(array[i]);
		}
		return result;
	}

	private Map<Integer, Integer> getMap(Entry[] array) {
		Map<Integer, Integer> map = new HashMap<>();
		for (Entry e : array) {
			map.put(e.value, e.count);
		}
		return map;
	}

	private void mergeSort(Entry[] array, int left, int right, Entry[] helper) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(array, left, mid, helper);
		mergeSort(array, mid + 1, right, helper);
		// merge
		for (int k = left; k <= right; k++) {
			helper[k] = array[k];
		}
		int i = left;
		int j = mid + 1;
		while (i <= mid && j <= right) {
			if (helper[i].value <= helper[j].value) {
				array[left] = helper[i++];
				array[left++].count += j - (mid + 1);
			} else {
				array[left++] = helper[j++];
			}
		}
		while (i <= mid) {
			array[left] = helper[i++];
			array[left++].count += j - (mid + 1);
		}
	}

	private Entry[] convert(int[] array) {
		Entry[] result = new Entry[array.length];
		for (int i = 0; i < array.length; i++) {
			result[i] = new Entry(array[i]);
		}
		return result;
	}


	static class Entry {
		int value;
		int count;
		public Entry(int value) {
			this.value = value;
			this.count = 0;
		}
	}
}
