package dp;

public class MinCutPalindrome {
	public int minCuts(String input) {
		if (input.length() == 0) {
			return 0;
		}
		int[] M = new int[input.length()]; 
		char[] array = input.toCharArray();
		for (int i = 1; i < array.length; i++) {
			if (isPalindrome(array, 0, i)) {
				M[i] = 0;
				continue;
			}
			int min = i;
			for (int j = 1; j <= i; j++) {        
				if (isPalindrome(array, j, i)) {
					min = Math.min(min, M[j - 1] + 1);
				}
			}
			M[i] = min;
		}
		return M[M.length - 1];
	}

	private boolean isPalindrome(char[] array, int left, int right) {
		while (left < right) {
			if (array[left] != array[right]) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
