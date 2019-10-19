package dataStrucure;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListU<Integer> l = new LinkedListU<Integer>();
		for (int i = 0; i < 5; i++) {
			l.add(i);
			l.display();
			System.out.println("\n");
		}
		l.delete();
		l.display();
		System.out.println("\n");
		l.delete();
		l.display();
	}

}
