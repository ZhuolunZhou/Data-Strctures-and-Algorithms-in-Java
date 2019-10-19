package laiOffer;

public class isPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null) return false;
		s = s.toLowerCase();
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (!isChar(s.charAt(left))) {
				left++;
				continue;
			}
			if (!isChar(s.charAt(right))) {
				right--;
				continue;
			}
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	private boolean isChar(char c) {
		return c >= 'a' && c <= 'z';
	}
}
