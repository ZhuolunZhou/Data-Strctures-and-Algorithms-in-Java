package dataStrucure;

public class LinkedListDoubly<T> {
	NodeD head;
	
	public LinkedListDoubly() {
		// TODO Auto-generated constructor stub
		head = null;
	}
	
	public void add(Object value) {
		NodeD newNode = new NodeD(value, null, null);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}
	
	public void delete() {
		head = head.next;
		head.prev = null;
	}
	
	public void display() {
		NodeD n = head;
		while (n != null) {
			System.out.print((T)n.value);
			n = n.next;
		}
	}

}
