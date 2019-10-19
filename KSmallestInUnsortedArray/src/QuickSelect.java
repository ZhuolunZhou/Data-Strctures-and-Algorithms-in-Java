import java.util.Arrays;

public class QuickSelect {

	public static void main(String[] args) {
		int[] a = new int[] {5,3,4,2,1,1,2,1,8,4,4,9,13,5,8, 6, 9};
		int[] res = kSmallest(a, 3);
		print(res);
		System.out.println();
		print(a);
	}

	public static int[] kSmallest(int[] array, int k) {
		// corner case
		if (array.length == 0 || k == 0) {
			return new int[0];
		}
		kSmallest(array, 0, array.length - 1, k - 1); // result is k smallest elements
		int[] result = Arrays.copyOf(array, k);
		Arrays.sort(result);
		return result;
	}

	private static void kSmallest(int[] array, int left, int right, int k) {
		int pivotIdx = partition(array, left, right);
		if (pivotIdx == k) { // found k smallest elements
			return;
		} else if (pivotIdx > k) { // k smallest elements on the left
			kSmallest(array, left, pivotIdx - 1, k);
		} else {
			kSmallest(array, pivotIdx + 1, right, k);
		}
	}

	// partition the array and return the pivot index
	private static int partition(int[] arr, int left, int right) {
		int pivotIdx = left + (int)(Math.random() * (right - left + 1));
		int pivot = arr[pivotIdx];
		//int pivot = arr[right];
		swap(arr, pivotIdx, right);
		int leftBound = left;
		int rightBound = right - 1;
		// [left, leftBound) < pivot
		// [leftBound, rightBound] unexplored
		// (rightBound, right] >= pivot
		while (leftBound <= rightBound) {
			if (arr[leftBound] < pivot) {
				leftBound++;
			} else if (arr[rightBound] >= pivot) {
				rightBound--;
			} else {
				swap(arr, leftBound++, rightBound--);
			}
		}
		swap(arr, leftBound, right);
		return leftBound;
	}

	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	} 
	
	private static void print(int[] array) {
		for (int a:array) {
			System.out.print("" + a + " ");
		}
	}
}
