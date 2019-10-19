package queue;

public class LinkedListQueue {
	private ListNode head; // queue's head
	private ListNode tail; // queue's tail
	private int size;
	
	public LinkedListQueue() {
		head = tail = null;
		size = 0;
	}
	
	// offer
	public void offer(int val) {
		ListNode newNode = new ListNode(val);
		if (tail == null) { // originally no elements in the queue
			tail = newNode;
			head = tail;
		} else {
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
	}
	// poll
	public Integer poll() {
		if (head == null) {
			return null;
		} 
		Integer res = head.value;
		head = head.next;
		if (head == null) { // queue becomes empty
			tail = null;
		}
		size--;
		return res;
	}
	// peek
	public Integer peek() {
		if (head == null) {
			return null;
		}
		return head.value;
	}
	// size
	public int size() {
		return size;
	}
	// check empty
	public boolean isEmpty() {
		return size == 0;
	}
}
