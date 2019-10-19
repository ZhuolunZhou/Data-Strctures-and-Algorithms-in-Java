package laioffer;

public class StackByLinkedList {
	ListNode head;
	int size;
	public StackByLinkedList() {
		head = null;
		size = 0;
	}
	
	public void push(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	public Integer pop() {
		if (head == null) {
			return null;
		}
		int val = head.value;
		head = head.next;
		size--;
		return val;
	}
	
	public Integer peek() {
		if (head == null) {
			return null;
		}
		return head.value;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void print() {
		ListNode cur = head;
		while (cur != null) {
			System.out.println(cur.value);
			cur = cur.next;
		}
	}
}

