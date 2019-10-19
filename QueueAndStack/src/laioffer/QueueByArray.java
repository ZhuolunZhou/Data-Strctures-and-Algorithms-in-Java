package laioffer;

public class QueueByArray {
	int[] array;
	int size;
	int head;
	int tail;
	public QueueByArray(int capacity) {
		size = 0;
		head = tail = 0;
		array = new int[capacity];
	}
	
	public void offer(int value) {
		if (size == array.length) {
			int[] newArray = new int[array.length*3/2];
			int index = 0;
			// put head to the left of the new array
			for (int i = head; i < array.length; i++) {
				newArray[index++] = array[i];
			}
			for (int j = 0; j <= tail; j++) {
				newArray[index++] = array[j];
			}
			head = 0;
			tail = array.length; // tricky!!!
			array = newArray;
		} 
		array[tail] = value;
		tail = tail+1 == array.length ? 0 : tail+1;
		size++;
	}
	
	public Integer poll() {
		if (size == 0) {
			return null;
		}
		int val = array[head++];
		head = head == array.length ? 0 : head;
		size--;
		return val;
	}
	
	public Integer peek() {
		if (size == 0) {
			return null;
		}
		return array[head];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void print() {
		// put head to the left of the new array
		for (int i = head; i < array.length; i++) {
			System.out.println(array[i]); 
		}
		for (int j = 0; j <= tail; j++) {
			System.out.println(array[j]); 
		}
	}
}
