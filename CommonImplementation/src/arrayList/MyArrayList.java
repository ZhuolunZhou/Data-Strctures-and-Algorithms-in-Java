package arrayList;

public class MyArrayList<E> {
	private E[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyArrayList(int capacity) {
		array = (E[]) new Object[capacity];
		size = 0;
	}
	public MyArrayList() {
		this(0);
	}
	
	// return the number of elements in the arraylist
	public int size() {
		return size;
	}
	
	// return true if the arraylist is empty
	public boolean isEmpty() {
		return size == 0;
	}
	
	// return the element at the specific position in the arraylist
	public E get(int index) {
		return array[index];
	}
	
	// replace the element at the specific position with the new element, and return the previous element
	public E set(int index, E newElement) {
		E prev = array[index];
		array[index] = newElement;
		return prev;
	}
	
	// add new element at the specific position
	public void add(int index, E element) {
		check();
		for (int i = size - 1; i >= index; i--) {
			array[i + 1] = array[i];
		}
		array[index] = element;
		size++;
	}
	
	// add new element at the end of arraylist
	public void add(E element) {
		check();
		array[size] = element;
		size++;
	}
	
	// check arraylist capacity and expand if necessary
	@SuppressWarnings("unchecked")
	private void check() {
		if (size >= array.length) {
			int newSize = array.length == 0 ? 2 : array.length * 3 / 2;
			E[] newArr = (E[]) new Object[newSize];
			for (int i = 0; i < array.length; i++) {
				newArr[i] = array[i];
			}
			array = newArr;
			newArr = null;
		}
	}
	
	// remove the element at the specific position, return the removed element
	public E remove(int index) {
		E removed = array[index];
		for (int i = index + 1; i < size; i++) {
			array[i - 1] = array[i];
		}
		array[size - 1] = null;
		size--;
		return removed;
	}
	
	// remove the first occurrence of specific element
	public void remove(E element) {
		// search
		int i = 0;
		for (i = 0; i < size; i++) {
			if (array[i].equals(element)) {
				break;
			}
		}
		remove(i);
	}
	
	// print elements in the arraylist
	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}








