
public class Solution {

	public static void main(String[] args) {
		
//		ListNode head = new ListNode(5);
//		head.next = new ListNode(4);
//		head.next.next = new ListNode(1);
//		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(6);
//		head.next.next.next.next.next = new ListNode(3);
//		ListNode newHead = selectionSort(head);
//		print(newHead);
//		int[] A1 = new int[]{2,1,2,5,7,1,9,3};
//		int[] A2 = new int[]{2,1,3};
//		A1 = sortSpecial(A1,A2);
//		int[] array = new int[] {2,0,0,1,1};
//		array = rainbowSortII(array);
//		for (int i:array) {
//			System.out.print(""+ i + " ");
//		}
		
	}
	
	public static ListNode reorder(ListNode head) {
	    // corner case
	    if (head == null || head.next == null) {
	      return head;
	    }
	    
	    // find mid and cut linked list 
	    ListNode mid = findMid(head);
	    print(mid);
	    System.out.println();
	    // reverse the second part of linked list
	    ListNode newHead = reverse(mid.next);
	    print(newHead);
	    System.out.println();
	    // merge two Linked Lists
	    mid.next = null;
	    ListNode finalHead = merge(head, newHead);
	    print(finalHead);
	    System.out.println();
	    return finalHead;
	  }
	  
	  // find mid node, mid is the first node when length is even
	  private static ListNode findMid(ListNode head) {
	    ListNode slow = head;
	    ListNode fast = head;
	    while (fast.next != null && fast.next.next != null) {
	      slow = slow.next;
	      fast = fast.next.next;
	    }
	    return slow;
	  }
	  
	  // reverse linked list
	  private static ListNode reverse(ListNode head) {
	    ListNode prev = null;
	    while (head != null) {
	      ListNode next = head.next;
	      head.next = prev;
	      prev = head;
	      head = next;
	    }
	    return prev;
	  }
	  
	  // merge two linked lists
	  private static ListNode merge(ListNode one, ListNode two) {
	    ListNode dummy = new ListNode(0);
	    ListNode tail = dummy;
	    boolean flag = true;
	    while (one != null && two != null) {
	      if (flag) {
	        tail.next = one;
	        one = one.next;
	      } else {
	        tail.next = two;
	        two = two.next;
	      }
	      flag = !flag;
	      tail = tail.next;
	    }
	    if (one != null) {
	      tail.next = one;
	    } 
	    if (two != null) {
	      tail.next = two;
	    }
	    return dummy.next;
	  }
	  
	  private static void print(ListNode head) {
		  ListNode cur = head;
		  while (cur != null) {
			  System.out.print(""+ cur.value + " ");
			  cur = cur.next;
		  }
	  }
	  
	  public static int[] sortSpecial(int[] A1, int[] A2) {
		  // corner case
		  if (A1 == null || A2 == null) {
			  return null;
		  }
		  int left = 0;
		  // sort A1 in A2 order
		  for (int i = 0; i < A2.length; i++) {
			  int val = A2[i];
			  int right = left; 
			  // traverse over A1
			  // [,left)  val
			  // [left,right] unexplored
			  // (right, length) != val
			  while (right < A1.length) {
				  if (A1[right] == val) {
					  swap(A1, left++, right++);
				  } else {
					  right++;
				  }
			  }
		  }
		  // if A1 has elements that are not in A2, merge sort in
		  // ascending order
		  if (left < A1.length - 1) {
			  int[] helper = new int[A1.length];
			  mergeSort(A1, left, A1.length - 1, helper);
		  }
		  return A1;
	  }  
	  
	  public static void mergeSort(int[] array, int left, int right, int[] helper) {
		  if (left >= right) {
			  return;
		  }
		  int mid = left + (right - left) / 2;
		  // divide
		  mergeSort(array, left, mid, helper);
		  mergeSort(array, mid+1, right, helper);
		  // copy elements from array to helper
		  for (int i = left; i <= right; i++) {
			  helper[i] = array[i];
		  }
		  // conquer
		  int i = left;
		  int j = mid + 1;
		  while (i <= mid && j <= right) {
			  if (helper[i] <= helper[j]) {
				  array[left++] = helper[i++];
			  } else {
				  array[left++] = helper[j++];
			  }
		  }
		  while (i <= mid) {
			  array[left++] = helper[i++];
		  }
		  while (j <= right) {
			  array[left++] = helper[j++];
		  }
  	  }
	  
	  private static void swap(int[] array, int a, int b) {
	    int temp = array[a];
	    array[a] = array[b];
	    array[b] = temp;
	  }

	  public static int[] rainbowSortII(int[] array) {
		  // corner case 
		  if (array == null || array.length == 0 || array.length == 1) {
			  return array;
		  }
		  // red=>a  green=>b  blue=>c  black=>d
		  // [0, a)  0
		  // [a, b)  1
		  // [b, c)  2  
		  // [c, d]  unexplored
		  // (d, length-1] 3
		  // move c from left to right
		  int a = 0;
		  int b = 0;
		  int c = 0;
		  int d = array.length - 1;
		  while (c <= d) {
			  int key = array[c];
			  if (key == 0) {
				  swap(array, a++, c);
				  if (a > b) {
					  b = a;	
				  } else if (a > c) {
					  c = a;
				  }
		      } else if (key == 1) {
		    	  swap(array, b++, c++);
		      } else if (key == 2) {
		    	  c++;
		      } else {
		    	  swap(array, d--, c);
		      }
		  }
		  return array;
	  }
	  
	  public static ListNode selectionSort(ListNode head) {
		  // corner case
		  if (head == null || head.next == null) {
			  return head;
		  }
		  ListNode dummy = new ListNode(0);		  
		  dummy.next = head;
		  ListNode cur = dummy;
		  while (head != null) {
		      ListNode prev = findPrevMin(head);
		      // now cur is the previous value of localMin
		      if (prev != null) {
		    	  ListNode localMin = prev.next;
			      cur.next = localMin;
			      prev.next = localMin.next;
			      localMin.next = head;
		      }	      
		      cur = cur.next;
		      head = cur.next;
		  }
//		  if (cur.value > head.value) {
//			  
//		  }
		  return dummy.next;
	  }
		  
	  private static ListNode findPrevMin(ListNode head) {
		  ListNode cur = head;
		  int count = 0;
		  int index = 0;
		  int localMin = Integer.MAX_VALUE;
		  // find the local min and its location
		  while (cur != null) {
			  if (cur.value < localMin) {
				  localMin = cur.value;
				  index = count;
			  }
		      cur = cur.next;
		      count++;
		  }
		  if (index == 0) {
			  return null;
		  } else {
			  cur = head; // reset
			  for (int i = 0; i < index - 1; i++) {
				  cur = cur.next;
			  }
			  return cur;
		  }
	  }
}

class ListNode {
	public int value;
	public ListNode next;
	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}