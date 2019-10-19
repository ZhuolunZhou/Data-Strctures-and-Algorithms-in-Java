package laiOffer;
import java.util.*;

public class ValidParenthesis {
	public List<String> validParentheses(int l, int m, int n) {
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		Deque<Character> stack = new ArrayDeque<>();
		int totalNum = (l + m + n) * 2;
		char[] parenthesis = new char[]{'(', ')', '<', '>', '{', '}'};
		int[] remain = new int[]{l, l, m, m, n, n};
		validParentheses(parenthesis, remain, sb, stack, result, totalNum);
		return result;
	}

	private void validParentheses(char[] parenthesis, int[] remain, StringBuilder sb,
			Deque<Character> stack, List<String> result, int total) {
		if (sb.length() == total) { 
			result.add(sb.toString());
			return;
		}
		for (int i = 0; i < parenthesis.length; i++) {
			if (i % 2 == 0) {  // left parenthesis
				if (remain[i] > 0) {
					sb.append(parenthesis[i]);
					stack.offerFirst(parenthesis[i]);
					remain[i]--;
					validParentheses(parenthesis, remain, sb, stack, result, total);
					sb.deleteCharAt(sb.length() - 1);          
					stack.pollFirst();
					remain[i]++;

				}
			} else { // right parenthesis
				if (!stack.isEmpty() && stack.peekFirst() == parenthesis[i - 1]) {
					stack.pollFirst();
					sb.append(parenthesis[i]);
					remain[i]--;
					validParentheses(parenthesis, remain, sb, stack, result, total);
					sb.deleteCharAt(sb.length() - 1);
					stack.offerFirst(parenthesis[i - 1]);
					remain[i]++;
				}
			}
		}
	}
}
