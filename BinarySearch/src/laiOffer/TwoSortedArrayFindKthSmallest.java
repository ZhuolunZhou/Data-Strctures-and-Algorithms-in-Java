package laiOffer;

public class TwoSortedArrayFindKthSmallest {
	public static int kth(int[] a, int[] b, int k) {
		return helper(a, b, 0, 0, k);
	}

	private static int helper(int[] a, int[] b, int aLeft, int bLeft, int k) {
		if (aLeft > a.length - 1) {
			return b[bLeft + k - 1];
		}
		if (bLeft > b.length - 1) {
			return a[aLeft + k - 1];
		}
		
		if (k == 1) {
			return a[aLeft] <= b[bLeft] ? a[aLeft] : b[bLeft];
		}
		int mid = k / 2;
		// find k/2th element
		int aVal = aLeft + mid - 1 >= a.length ? Integer.MAX_VALUE : a[aLeft + mid - 1];
		int bVal = bLeft + mid - 1 >= b.length ? Integer.MAX_VALUE : b[bLeft + mid - 1];

		if (aVal <= bVal) {
			return helper(a, b, aLeft + mid, bLeft, k - mid);
		} else {
			return helper(a, b, aLeft, bLeft + mid, k - mid);
		}
	}
}
