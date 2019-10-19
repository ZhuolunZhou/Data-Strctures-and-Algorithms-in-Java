package laioffer;

public class ArrayStack {
	private int[] array;
	private int top; // top of stack
	private int size;
	
	public ArrayStack() {
		array = new int[2];
		top = -1;
		size = 0;
	}
	
	// push
	public void push(int val) {
		if (size == array.length) {
			resize();
		}
		array[++top] = val;
		size++;
	}
	
	// pop
	public Integer pop() {
		if (size == 0) {
			return null; 
		}
		Integer res = array[top--];
		size--;
		return res;
	}
	
	// peek
	public Integer peek() {
		if (size == 0) {
			return null;
		}
		return array[top];
	}
	
	
	// resize
	private void resize() {
		int[] newArr = new int[array.length * 3 / 2];
		for (int i = 0; i < array.length; i++) {
			newArr[i] = array[i];
		}
		array = newArr;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void print() {
		for (int i = 0; i <= top; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}







