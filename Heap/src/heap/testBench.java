package heap;
import java.util.*;

public class testBench {
	public static void main(String[] args) {
//		MergeKSortedLists ml = new MergeKSortedLists();
//		ListNode head1 = new ListNode(1);
//		head1.next = new ListNode(6);
//		head1.next.next = new ListNode(7);
//		ListNode head2 = new ListNode(2);
//		head2.next = new ListNode(2);
//		List<ListNode> list = new ArrayList<>();
//		ListNode head3 = new ListNode(-2);
//		head3.next = new ListNode(5);
//		head3.next.next = new ListNode(10);
//		ListNode head4 = null;
//		list.add(head1);
//		list.add(head2);
//		list.add(head3);
//		list.add(head4);
//		ListNode newHead = ml.merge(list);
//		ListNode cur = newHead;
//		while (cur != null) {
//			System.out.println(cur.value);
//			cur = cur.next;
//		}
//		kClosestToOrigin ko = new kClosestToOrigin();
//		int[] a = {1,2,3};
//		int[] b = {2,4};
//		int[] c = {1,2};
//		List<Integer> result = ko.closest(a, b, c, 10);
//		for (int i : result) {
//			System.out.print(i + " ");
//		}
//		KSmallest k = new KSmallest();
//		int[] array = {5,3,4,2,1,1,2,1,8,4,4,9,13,5,8};
//		int[] result= k.kSmallest(array, 5);
//		for (int i : result) {
//			System.out.print(i + " ");
//		}
//		KWayMerge km = new KWayMerge();
//		int[][] arr = new int[][] {{3},{1,2,3,4,5}};
//		int[] result = km.merge(arr);
//		for (int i : result) {
//			System.out.println(i);
//		}
//		KthSmallestWithFactors kf = new KthSmallestWithFactors();
//		System.out.println(kf.kth(3));
//		SkyLine sl = new SkyLine();
//		int[][] buildings = {{0,2,3},{2,5,3}};
//		List<List<Integer>> res = sl.getSkyline(buildings);
//		for (List<Integer> i : res) {
//			System.out.println(i);
//		}
		MinCostHireKWorkers w = new MinCostHireKWorkers();
		System.out.println(w.mincostToHireWorkers(new int[] {10,20,5}, new int[] {70,50,30}, 2));
		
	}
}
