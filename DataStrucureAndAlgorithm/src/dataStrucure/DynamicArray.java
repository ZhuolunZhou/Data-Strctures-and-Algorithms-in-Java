package dataStrucure;

import java.util.Arrays;

public class DynamicArray<T> {
	Object[] data;
	int capacity;
	int cur_size;
	public DynamicArray() {
		// TODO Auto-generated constructor stub
		capacity = 1;
		cur_size = 0;
		data = new Object[1];
	}
	
	public int getSize() {
		return data.length;
	}
	
	public T get(int index) {
		return (T) data[index];
	}
	
	public void put(T element) {
		cur_size++;
		if (cur_size > capacity) {
			capacity *= 2;
			data = Arrays.copyOf(data,capacity);	
		}
		data[cur_size-1] = element;
	}
	
}
