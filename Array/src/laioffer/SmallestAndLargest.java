package laioffer;

public class SmallestAndLargest {
	public int[] largestAndSmallest(int[] array) {
		int n = array.length;
		// compare by pairs, left array > right array
		for (int i = 0; i < n / 2; i++) {
			if (array[i] < array[n - 1 - i]) {
				swap(array, i, n - 1 - i);
			}
		}
		// find largest
		int largest = array[0];
		for (int i = 0; i <= (n - 1) / 2; i++) {
			largest = Math.max(largest, array[i]);
		}
		// if n is odd, (n-1)/2 == n/2
		// if n is even, (n-1)/2 + 1 == n/2
		// find smallest
		int smallest = array[n / 2]; 
		for (int i = n / 2; i < n; i++) {
			smallest = Math.min(smallest, array[i]);
		}
		return new int[]{largest, smallest};
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
