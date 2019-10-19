package dataStrucure;


public class DynamicArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicArray<Integer> a = new DynamicArray<Integer>();
		//System.out.println(a.cur_size);

		for (int i=0; i < 5; i++) {
			a.put(i);
			System.out.println(a.data[i]+" current size is " + a.capacity);
		}
	}

}
