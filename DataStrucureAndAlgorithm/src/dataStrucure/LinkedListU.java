package dataStrucure;

public class LinkedListU<T> {
	Node head;
	
	public LinkedListU() {
		// TODO Auto-generated constructor stub
		head = null;
	}
	
	public void add(int value) {
		Node newNode = new Node(value, null);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	public void delete() {
		head = head.next;
	}
	
	public void display() {
		Node n = head;
		while (n != null) {
			System.out.print((Integer)n.value + " ");
			n = n.next;
		}
		System.out.println("\n");
	}

}
