package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumII {
	public List<String> findStrobogrammatic(int n) {
		List<String> result = new ArrayList<>();
		if (n <= 0) return result;
		Map<Character, Character> map = new HashMap<>();
		map.put('0','0');
		map.put('1','1');
		map.put('8','8');
		map.put('6','9');
		map.put('9','6');
		StringBuilder sb = new StringBuilder();
		for (Character key : map.keySet()) {
			if (key == '0') continue;
			sb.append(key);
			build(map, sb, result, n);
			sb.deleteCharAt(sb.length() - 1);
		}
		return result;
	}

	private void build(Map<Character, Character> map, StringBuilder sb, List<String> result, int n) {
		if (sb.length() == n) {
			result.add(sb.toString());
			return;
		}
		int nextIdx = sb.length();
		if (nextIdx < n / 2) {
			for (Character c : map.keySet()) {
				sb.append(c);
				build(map, sb, result, n);
				sb.deleteCharAt(sb.length() - 1);
			}
		} else if (n % 2 == 1 && nextIdx == n / 2) {
			sb.append('0');
			build(map, sb, result, n);
			sb.deleteCharAt(sb.length() - 1);
			sb.append('1');
			build(map, sb, result, n);
			sb.deleteCharAt(sb.length() - 1);
			sb.append('8');
			build(map, sb, result, n);
			sb.deleteCharAt(sb.length() - 1);
		} else {
			char c = sb.charAt(n - nextIdx - 1);
			sb.append(map.get(c));
			build(map, sb, result, n);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
