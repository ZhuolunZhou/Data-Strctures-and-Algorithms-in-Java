package laioffer;

public class StackByArray {
	int size;
	int[] array;
	int head;
	
	public StackByArray(int capacity) {
		size = 0;
		head = -1;
		array = new int[capacity];
	}
	
	public void push(int value) {
		if (head + 1 >= array.length) { //array is full
			int[] newArray = new int[array.length * 3 / 2];
			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}
		array[++head] = value;
		size++;
	}
	
	public Integer pop() {
		if (size == 0) {
			return null;
		}
		size--;
		return array[head--];
	}
	
	public Integer peek() {
		return size == 0 ? null : array[head];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void print() {
		for (int i = 0; i <= head; i++) {
			System.out.println(i);
		}
	}
}
