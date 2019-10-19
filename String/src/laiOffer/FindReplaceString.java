package laiOffer;
import java.util.*;

public class FindReplaceString {
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		// corner case
		if (S.length() == 0 || indexes.length == 0 || sources.length == 0 || targets.length == 0) return S;
		// step 1: check whether sources[i] matches S at indexes[i]
		// step 2: replace
		TreeMap<Integer, String> map = getMap(S, indexes, sources, targets);
		StringBuilder sb = new StringBuilder();
		int start = 0;
		while (!map.isEmpty()) {
			Map.Entry<Integer, String> entry = map.pollFirstEntry();
			int idx = entry.getKey();
			String target = entry.getValue();
			sb.append(S.substring(start, idx));
			sb.append(target);
			start = idx + sources[idx].length();
		}
		if (start < S.length()) sb.append(S.substring(start));
		return sb.toString();
	}

	private TreeMap<Integer, String> getMap(String S, int[] indexes, String[] sources, String[] targets) {
		TreeMap<Integer, String> map = new TreeMap<>();
		char[] array = S.toCharArray();
		for (int i = 0; i < indexes.length; i++) {
			if (valid(array, indexes[i], sources[i])) {
				map.put(indexes[i], targets[i]);
			}
		}
		return map;
	}

	private boolean valid(char[] array, int index, String source) {
		for (int i = 0; i < source.length(); i++) {
			if (array[index + i] != source.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
