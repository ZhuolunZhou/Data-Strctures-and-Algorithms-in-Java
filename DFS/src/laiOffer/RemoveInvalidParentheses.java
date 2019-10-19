package laiOffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int[] max = {0};
		dfs(s, 0, sb, 0, 0, list, max);
		List<String> result = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for (String str : list) {
			if (str.length() == max[0] && set.add(str)) {
				result.add(str);
			}
		}
		return result;
	}

	private void dfs(String s, int index, StringBuilder sb, int countLeft, 
			int countRight, List<String> result, int[] max) {
		if (index >= s.length()) {
			if (countLeft == countRight) {
				result.add(sb.toString());
				max[0] = Math.max(max[0], sb.length());
			}
			return;
		}
		char c = s.charAt(index);
		if (Character.isLetter(c)) {
			dfs(s, index + 1, sb.append(c), countLeft, countRight, result, max);
			sb.deleteCharAt(sb.length() - 1);
		} else {
			if (c == '(') {
				dfs(s, index + 1, sb.append('('), countLeft + 1, countRight, result, max);
				sb.deleteCharAt(sb.length() - 1);
				dfs(s, index + 1, sb, countLeft, countRight, result, max);
			} else {
				if (countLeft > countRight) {
					dfs(s, index + 1, sb.append(')'), countLeft, countRight + 1, result, max);
					sb.deleteCharAt(sb.length() - 1);
				} 
				dfs(s, index + 1, sb, countLeft, countRight, result, max);
			}
		}
	}
}
