package laiOffer;

public class ReorderLog {
	public String[] reorderLogFiles(String[] logs) {
		String[] helper = new String[logs.length];
		mergeSort(logs, 0, logs.length - 1, helper);
		return logs;
	}

	private void mergeSort(String[] array, int left, int right, String[] helper) {
		if (left >= right) return;
		int mid = left + (right - left) / 2;
		mergeSort(array, left, mid, helper);
		mergeSort(array, mid + 1, right, helper);
		// copy current array
		for (int i = left; i <= right; i++) {
			helper[i] = array[i];
		}
		// merge
		int leftBound = left;
		int rightBound = mid + 1;
		while (leftBound <= mid && rightBound <= right) {
			String[] arr1 = helper[leftBound].split("\\s+");
			String[] arr2 = helper[rightBound].split("\\s+");
			if (isDigit(arr1[1]) && isDigit(arr2[1])) {
				array[left++] = helper[leftBound++];
			} else if (isDigit(arr1[1])) {
				array[left++] = helper[rightBound++];
			} else if (isDigit(arr2[1])) {
				array[left++] = helper[leftBound++];
			} else { // both are letter-logs
				int priority = 0;
				int i;
				for (i = 1; i < arr1.length && i < arr2.length; i++) {
					if (arr1[i].compareTo(arr2[i]) < 0) {
						priority = -1;
						break;
					} else if (arr1[i].compareTo(arr2[i]) > 0) {
						priority = 1;
						break;
					} else {
						priority = 0;
					}
				}
				if (priority == -1) {
					array[left++] = helper[leftBound++];
				} else if (priority == 1) {
					array[left++] = helper[rightBound++];
				} else if (i == arr1.length && i == arr2.length) { // tie
					array[left++] = arr1[0].compareTo(arr2[0]) < 0 ? helper[leftBound++] : helper[rightBound++];
				} else if (i < arr1.length) {
					array[left++] = helper[rightBound++];
				} else {
					array[left++] = helper[leftBound++];
				}
			}
		}
		while (leftBound <= mid) {
			array[left++] = helper[leftBound++];
		}
	}

	private boolean isDigit(String s) {
		return Character.isDigit(s.charAt(0));
	}
}
