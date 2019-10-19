package laiOffer;
import java.util.*;

public class LongestSubStringII {
	public String longest(String input, int k) {
		if (k == 0) {
			return new String();
		}
		if (input == null || input.length() == 0) {
			return null;
		}

		// there are exactly k type of characters in sliding window
		int left = 0;
		int right = 0;
		Map<Character, Integer> map = new HashMap<>();
		int globalMax = 0;
		int l = 0;
		int r = 0;
		while (right < input.length()) {
			char cur = input.charAt(right);
			Integer val = map.get(cur);
			if (map.size() < k) {
				if (val == null) {
					map.put(cur, 1);
				} else {
					map.put(cur, val + 1);
				}
				right++;
				
			} else {
				if (val != null) {
					map.put(cur, val + 1);
					right++;
				} else {
					int lVal = map.get(input.charAt(left));
					lVal--;
					if (lVal == 0) {
						map.remove(input.charAt(left));  
					} else {
						map.put(input.charAt(left), lVal);
					}
					left++;
				} 
			} 
			if (globalMax < right - left) {
				globalMax = right - left;
				l = left;
				r = right;
			}
		}
		if (map.size() < k) {
			return null;
		} else {
			char[] arr = input.toCharArray();
			return new String(arr, l, r - l);
		}
	}
}
