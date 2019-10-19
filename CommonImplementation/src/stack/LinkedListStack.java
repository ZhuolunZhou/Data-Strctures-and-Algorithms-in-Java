package stack;

public class LinkedListStack {
	private ListNode top; // top of stack
	private int size;
	
	public LinkedListStack() {
		top = null;
		size = 0;
	}
	// push
	void push(int val) {
		ListNode newNode = new ListNode(val);
		newNode.next = top;
		top = newNode;
		size++;
	}
	
	// pop
	Integer pop() {
		if (top == null) {
			return null;
		}
		Integer res = top.value;
		top = top.next;
		size--;
		return res;
	}
	
	// peek
	Integer peek() {
		if (top == null) {
			return null;
		}
		return top.value;
	}
	
	// size
	int size() {
		return size;
	}
	// check empty
	boolean isEmpty() {
		return size == 0;
	}
}
