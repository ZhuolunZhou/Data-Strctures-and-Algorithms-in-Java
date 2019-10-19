package laioffer;

public class GetCountArray {
	public int[] countArray(int[] array) {
		if (array == null || array.length == 0) return array;
		int N = array.length;
		int[] indexArray = new int[N];
		for (int i = 0; i < N; i++) indexArray[i] = i;
		int[] countArray = new int[N];
		int[] helper = new int[N];
		mergeSort(array, indexArray, countArray, helper, 0, N - 1);
		return countArray;
	}
	
	private void mergeSort(int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int right) {
		if (left >= right) return;
		int mid = left + (right - left) / 2;
		mergeSort(array, indexArray, countArray, helper, left, mid);
		mergeSort(array, indexArray, countArray, helper, mid + 1, right);
		for (int i = left; i <= right; i++) {
			helper[i] = indexArray[i];
		}
		int leftBound = left, rightBound = mid + 1;
		while (leftBound <= mid) {
			if (rightBound > right || array[helper[leftBound]] <= array[helper[rightBound]]) {
				countArray[helper[leftBound]] += rightBound - (mid + 1);
				indexArray[left++] = helper[leftBound++];
 			} else {
 				indexArray[left++] = helper[rightBound++];
 			}
		}
	}
}
