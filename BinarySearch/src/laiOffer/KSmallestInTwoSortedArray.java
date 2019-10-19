package laiOffer;

public class KSmallestInTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int kSmallest(int[] a, int[] b, int k) {
		return kth(a,0,b,0,k);
	}
	
	private int kth(int[] a, int aleft, int[] b, int bleft, int k) {
		// base case
		if (aleft >= a.length) {
			return b[bleft + k - 1];
		}
		if (bleft >= b.length) {
			return a[aleft + k - 1];
		}
		if (k == 1) {
			return Math.min(aleft, bleft);
		}
		
		int amid = aleft + k/2 - 1;
		int bmid = bleft + k/2 - 1;
		
		int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
		int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
		
		if (aval <= bval) {
			return kth(a, amid+1, b, bleft, k-k/2);
		}
		return kth(a, aleft, b, bmid+1, k-k/2);			
	}
	

}
