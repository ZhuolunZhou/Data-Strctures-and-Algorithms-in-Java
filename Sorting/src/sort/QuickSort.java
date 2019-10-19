package sort;

public class QuickSort {
	public int[] quickSort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		quickSort(array, 0, array.length - 1);
		return array;
	}

	private void quickSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		// randomly generates a pivot idx
		int pivotIdx = (int)(Math.random() * (right - left + 1)) + left;
		int pivot = array[pivotIdx];
		swap(array, pivotIdx, right);
		int i = 0; 
		int j = right - 1;
		while (i <= j) {
			if (array[i] <= pivot) {
				i++;
			} else {
				swap(array, i, j--);
			}
		}
		swap(array, right, i); // put the pivot to the right place
		quickSort(array, left, i - 1);
		quickSort(array, i + 1, right);
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
