package laioffer;

public class ArrayQueue {
	// [array[left], array[right]) => queue
	private int left; 
	private int right;
	private int[] array;
	private int size;

	public ArrayQueue() {
		left = right = 0;
		array = new int[2];
		size = 0;
	}

	// offer
	public void offer(int val) {
		// check whether array is full
		if (size == array.length) {
			resize();
		}
		array[right++] = val;
		right = right == array.length ? 0 : right;
		size++;
	}

	// poll
	public Integer poll() {
		if (size == 0) {
			return null;
		}
		Integer res = array[left++];
		left = left == array.length ? 0 : left;
		size--;
		return res;
	}
	// peek
	public Integer peek() {
		if (size == 0) {
			return null;
		}
		return array[left];
	}
	// resize
	private void resize() {
		int[] newArr = new int[array.length * 3 / 2];
		int leftBound = 0;
		for (int i = left; i < array.length; i++) {
			newArr[leftBound++] = array[i];
		}
		for (int i = 0; i < right; i++) {
			newArr[leftBound++] = array[i];
		}
		array = newArr;
		left = 0;
		right = leftBound;
	}
	// size
	public int size() {
		return size;
	}

	// check emptyness
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void print() {
		if (left < right) {
			for (int i = left; i < right; i++) {
				System.out.print(array[i] + " ");
			}
		} else {
			for (int i = left; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
			for (int i = 0; i < right; i++) {
				System.out.print(array[i] + " ");
			}
		}
		System.out.println();
	}
	
	public int capacity() {
		return array.length;
	}
}
