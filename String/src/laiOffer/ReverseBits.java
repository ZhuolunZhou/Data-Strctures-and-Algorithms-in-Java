package laiOffer;

public class ReverseBits {
	public int reverseI(int a) {
		if (a == 0) {
			return a;
		}
		int left = 0;
		int right = 31;
		while (left < right) {
			a = swapBits(a, left, right);
			left++;
			right--;			
		}
		return a;
	}

	public int reverseII(int a) {
		if (a == 0) {
			return a;
		}
		int b = 0;
		for (int i = 0; i < 32; i++) {
			b = (b << 1) + (a & 1);
			a >>= 1;
		}
		return b;
	}
	
	private int swapBits(int a, int left, int right) {
		int leftBit = (a >> right) & 1;
		int rightBit = (a >> left) & 1;
		if (leftBit == rightBit) {
			return a;
		}
		a ^= ((1 << left) | (1 << right));
		return a;
	}
}
