package dp;

public class JumpGame {
	public boolean canJump(int[] array) {
		boolean[] M = new boolean[array.length];
		M[array.length - 1] = true; // smallest case
		for (int i = array.length - 1; i >= 0; i--) {
			if (i + array[i] >= array.length) {
				M[i] = true;
			} else {
				for (int j = i; j <= i + array[i]; j++) {
					if (M[j] == true) {
						M[i] = true;
						break;
					}  
				}
			}	
		}
		return M[0];
	}
}
