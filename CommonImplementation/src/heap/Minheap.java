package heap;

import java.util.NoSuchElementException;

public class Minheap {
	private int[] array;
	private int size;
	
	public Minheap(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("input array cannot be null or empty");
		}
		this.array = array;
		size = array.length;
		heapify();
	}
	
	public Minheap(int cap) {
		if (cap <= 0) {
			throw new IllegalArgumentException("capacity cannot be <= 0");
		}
		array = new int[cap];
		size = 0;
	}
	
	private void heapify() {
		// last parent = (size - 1 - 1) / 2 = size / 2 - 1
		for (int i = size / 2 - 1; i >= 0; i--) {
			percolateDown(i);
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void offer(int ele) {
		checkSize();
		array[size] = ele;
		size++;
		percolateUp(size - 1);
	}
	
	public int poll() {
		if (size == 0) {
			throw new NoSuchElementException("heap is empty");
		}
		int result = array[0];
		array[0] = array[size - 1];
		size--;
		percolateDown(0);
		return result;
	}
	
	public int peek() {
		if (size == 0) {
			throw new NoSuchElementException("heap is empty");
		}
		return array[0];
	}
	
	public int update(int index, int ele) {
		if (index < 0 || index > size - 1) {
			throw new ArrayIndexOutOfBoundsException("invalid index range");
		}
		int result = array[index];
		array[index] = ele;
		if (result > ele) {
			percolateUp(index);
		} else {
			percolateDown(index);
		}
		return result;
	}
	
	private void checkSize() {
		if (size == array.length) {
			int length = size == 1 ? 2 : size * 3 / 2;
			int[] newArr = new int[length];
			for (int i = 0; i < size; i++) {
				newArr[i] = array[i];
			}
			array = newArr;
			newArr = null;
		}
	}
	
	private void percolateUp(int index) {
		while (index > 0) {
			int parentIdx = (index - 1) / 2;
			if (array[parentIdx] > array[index]) {
				swap(array, parentIdx, index);
			} else {
				break;
			}
			index = parentIdx;
		}
	}
	
	private void percolateDown(int index) {
		while (index <= size / 2 - 1) {
			int leftChildIdx = index * 2 + 1;
			int rightChildIdx = index * 2 + 2;
			int swapCandidate = leftChildIdx;
			if (rightChildIdx <= size - 1 && array[leftChildIdx] >= array[rightChildIdx]) {
				swapCandidate = rightChildIdx;
			}
			if (array[index] > array[swapCandidate]) {
				swap(array, index, swapCandidate);
			} else {
				break;
			}
			index = swapCandidate;
		}
	}
	
	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}




