package laiOffer;

public class MySqrt {
	public int mySqrt(int x) {
		if (x == 0 || x == 1) return x;
		int left = 1, right = x, ans = 0;
		while (left <= right){
			int mid = left + (right - left) / 2;
			if ((long)mid * mid == (long)x){
				return mid;
			} else if ((long)mid * mid > x){
				right = mid - 1;
			} else {
				left = mid + 1;
				ans = mid;
			}

		}
		return ans;
	}
}
