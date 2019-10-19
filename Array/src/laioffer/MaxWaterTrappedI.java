package laioffer;

public class MaxWaterTrappedI {
	public int maxTrapped(int[] array) {
		if (array.length == 0) return 0;
		int left = 0;
		int right = array.length - 1;
		int lmax = array[left];
		int rmax = array[right];
		int result = 0;
		while (left < right) {
			if (lmax <= rmax) {
				result += lmax - array[left];
				left++;
				if (left < array.length) {
				lmax = Math.max(lmax, array[left]);
				}
				
			} else {
				result += rmax - array[right];
				right--;
				if (right >= 0) {
					rmax = Math.max(rmax, array[right]);
				}
			}
		}
		return result;   
	}
}
