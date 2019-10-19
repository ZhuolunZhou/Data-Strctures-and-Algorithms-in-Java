package recursion;

public class StringAbbreviation {
	public boolean match(String input, String pattern) {
		return helper(input, pattern, 0, 0);
	}

	private boolean helper(String input, String pattern, int inputIdx, int patternIdx) {
		// base case: if any index is out of bound
		if (inputIdx == input.length() && patternIdx == pattern.length()) {
			return true;
		} else if (inputIdx >= input.length() || patternIdx >= pattern.length()) {
			return false;
		}
		if (pattern.charAt(patternIdx) < '0' || pattern.charAt(patternIdx) > '9') {
			return input.charAt(inputIdx) == pattern.charAt(patternIdx) ? helper(input, pattern, inputIdx + 1, patternIdx + 1) : false;
		} else {
			int number = 0;
			while (patternIdx < pattern.length() && pattern.charAt(patternIdx) >= '0' && pattern.charAt(patternIdx) <= '9') {
				number = number * 10 + (pattern.charAt(patternIdx) - '0');
				patternIdx++;
			}
			// current char of pattern is not number
			inputIdx += number; // skip "number" indices
			return helper(input, pattern, inputIdx, patternIdx);
		}
	}
}
