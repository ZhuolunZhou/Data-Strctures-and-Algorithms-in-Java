package laiOffer;
import java.util.*;

public class WordBreakII {
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> result = new ArrayList<>();
		Set<String> set = new HashSet<>(wordDict);
		StringBuilder sb = new StringBuilder();
		dfs(s, set, sb, result);
		return result;
	}

	// index is the start position of the potential word
	//	private void dfs(String s, int index, Set<String> set, StringBuilder sb, List<String> result) {
	//		if (index == s.length()) {
	//			result.add(sb.deleteCharAt(sb.length() - 1).toString());
	//			sb.append(' ');
	//			return;
	//		}
	//		for (int i = index + 1; i <= s.length(); i++) { // find word in the dict [index, i)
	//			if (set.contains(s.substring(index, i))) {
	//				dfs(s, i, set, sb.append(s.substring(index, i)).append(' '), result);
	//				sb.delete(sb.length() - (i - index) - 1, sb.length());
	//			}
	//		}
	//	}

	private void dfs(String s, Set<String> set, StringBuilder sb, List<String> result) {
		if (s.length() == 0) {
			result.add(sb.deleteCharAt(sb.length() - 1).toString());
			sb.append(' ');
			return;
		}
		for (int i = 1; i <= s.length(); i++) { // find word in the dict [index, i)
			if (set.contains(s.substring(0, i))) {
				dfs(s.substring(i), set, sb.append(s.substring(0, i)).append(' '), result);
				sb.delete(sb.length() - i - 1, sb.length());
			}
		}
	}
}
