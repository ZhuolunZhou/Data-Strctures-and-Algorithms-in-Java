import java.util.*;

public class SortWith3Stacks {
	public void sort(LinkedList<Integer> s1) {
		LinkedList<Integer> s2 = new LinkedList<Integer>();
		LinkedList<Integer> s3 = new LinkedList<Integer>();
		mergeSort(s1, s2, s3, s1.size());
	}

	public void mergeSort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int size) {
		if (size <= 1) {
			return;
		}
		for (int i = 0; i < size / 2; i++) {
			s2.offerFirst(s1.pollFirst());
		}
		mergeSort(s1, s3, s2, size - size / 2);
		mergeSort(s2, s3, s1, size / 2);
		// combine
		while (!s1.isEmpty() && !s2.isEmpty()) {
			if (s1.peekFirst() <= s2.peekFirst()) {
				s3.offerFirst(s1.pollFirst());
			} else {
				s3.offerFirst(s2.pollFirst());
			}
		}
		while (!s1.isEmpty()) {
			s3.offerFirst(s1.pollFirst());
		} 
		while (!s2.isEmpty()) {
			s3.offerFirst(s2.pollFirst());
		}
		// put elements back to s1
		for (int i = 0; i < size; i++) {
			s1.offerFirst(s3.pollFirst());
		}
	}
}
