package laiOffer;

public class StringAbbreviation {
	public boolean match(String input, String pattern) {
		if (input.length() == 0 && pattern.length() == 0) {
			return true;
		} if (input.length() == 0 || pattern.length() == 0) {
			return false;
		}
		int p = 0; // pointer of pattern
		int i = 0; // pointer of input
		while (p < pattern.length()) {
			char cur = pattern.charAt(p);
			if (!isNum(cur)) { // is a character
				if (i >= input.length() || cur != input.charAt(i)) {
					return false;
				}
				p++;
				i++;
			} else { // is a number
				int num = 0;
				while (p < pattern.length() && isNum(pattern.charAt(p))) {
					num = num * 10 + (pattern.charAt(p) - '0');
					p++;
				}
				i += num;
			}
		}
		return i == input.length();
	}
	
	private boolean isNum(char c) {
		return c >= '0' && c <= '9';
	}
}
