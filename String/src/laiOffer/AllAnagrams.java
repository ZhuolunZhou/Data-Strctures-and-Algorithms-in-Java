package laiOffer;
import java.util.*;

public class AllAnagrams {
	public List<Integer> allAnagrams(String sh, String lo) {
		List<Integer> result = new ArrayList<Integer>();
		if (lo.length() == 0 || sh.length() > lo.length()) {
			return result;
		}
		char[] s = sh.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		int typeToMatch = 0; // record the number of kinds of characters
		for (int i = 0; i < s.length; i++) {
			Integer val = map.get(s[i]);
			if (val == null) {
				map.put(s[i], 1);
				typeToMatch++;
			} else {
				map.put(s[i], val + 1);
			}
		}
		
		for (int i = 0; i < lo.length(); i++) {
			// handle new char
			char cur = lo.charAt(i);
			Integer val = map.get(cur);
			if (val != null) {
				val--;
				map.put(cur, val);
				if (val == 0) {
					typeToMatch--;
				}
			}
			// handle left most char
			if (i >= sh.length()) {
				char leftMost = lo.charAt(i - sh.length());
				val = map.get(leftMost);
				if (val != null) {
					val++;
					map.put(leftMost, val);
					if (val == 1) {
						typeToMatch++;
					}
				}
			}
			if (typeToMatch == 0) {
				result.add(i - sh.length() + 1);
			}
		}
		return result;
	}
}
