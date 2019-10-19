package arrayList;

public class TestBench {

	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		System.out.println(list.size());
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.remove(1);
		list.add(12);
		list.add(21);
		list.add(35);
		list.set(3, 15);
		list.add(1, 99);
		list.add(3, 88);
		list.remove(3);
		list.remove(3);
		list.print();
		System.out.println(list.size());
	}
}
