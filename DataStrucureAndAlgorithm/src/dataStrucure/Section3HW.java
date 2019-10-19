package dataStrucure;
import java.util.*;
/*
 *  Combine two linked list from end to middle
 */
public class Section3HW {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListU<Integer> ls1 = new LinkedListU<Integer>();
		LinkedListU<Integer> ls2 = new LinkedListU<Integer>();
		ls1.add(20);
		ls1.add(15);
		ls1.add(10);
		ls1.add(5);
		ls1.add(1);
		
		ls2.add(14);
		ls2.add(13);
		ls2.add(12);
		ls2.add(11);
		ls2.add(5);
		
		ls1.display();
		ls2.display();
		
		Stack<Integer> s = new Stack<Integer>();
		Node swap = ls2.head;
		while (swap != null) {
			s.push(swap.value);
			swap = swap.next;
		}
		
		System.out.println(s);
		LinkedListU<Integer> newLs = new LinkedListU<Integer>();
		newLs.head = ls1.head;
		
		Node track = newLs.head;
		int count = 0;
		while (!s.isEmpty()) {
			if (count % 2 == 0) {
				int val = s.pop();
				Node nextN = track.next;
				Node newN = new Node(val,null);
				track.next = newN;
				newN.next = nextN;
	
			}
			track = track.next;
			count++;
		}
		newLs.display();
		
	}

}
