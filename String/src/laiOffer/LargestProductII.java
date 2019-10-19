package laiOffer;
import java.util.*;

public class LargestProductII {
	public int largestProduct(String[] dict) {
		Arrays.sort(dict, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return 0;
				}
				return s1.length() > s2.length() ? -1 : 1;
			}
		});
		Queue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				int length1 = p1.lenProduct;
				int length2 = p2.lenProduct;
				if (length1 == length2) return 0;
				return length1 > length2 ? -1 : 1;
			}
		});
		maxHeap.offer(new Pair(0,1,dict));
		while (!maxHeap.isEmpty()) {
			Pair cur = maxHeap.poll();
			if (cur.idx1 != cur.idx2 && noCommon(dict[cur.idx1], dict[cur.idx2])) {
				return cur.lenProduct;
			}
			if (cur.idx1 + 1 < dict.length) {
				maxHeap.offer(new Pair(cur.idx1 + 1, cur.idx2, dict));
			}
			if (cur.idx2 + 1 < dict.length) {
				maxHeap.offer(new Pair(cur.idx1, cur.idx2 + 1, dict));
			}
		}
		return 0;
	}

	private boolean noCommon(String s1, String s2) {
		int num1 = convert(s1);
		int num2 = convert(s2);
		return (num1 & num2) == 0;
	}

	private int convert(String s) {
		int result = 0;
		for (char c : s.toCharArray()) {
			int idx = c - 'a';
			result |= (1 << idx);
		}
		return result;
	}

	static class Pair {
		int idx1;
		int idx2;
		String[] dict;
		int lenProduct;
		public Pair(int idx1, int idx2, String[] dict) {
			this.idx1 = idx1;
			this.idx2 = idx2;
			this.dict = dict;
			this.lenProduct = dict[idx1].length() * dict[idx2].length();
		}
	}

}





