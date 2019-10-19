package laiOffer;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {
	public String decodeString(String s) {
		String res = "";
		Deque<Integer> countStack = new LinkedList<>();
		Deque<String> resStack = new LinkedList<>();
		int idx = 0;
		while (idx < s.length()) {
			char c = s.charAt(idx);
			if (Character.isDigit(c)) {
				int count = 0;
				while (Character.isDigit(s.charAt(idx))) {
					count = 10 * count + (s.charAt(idx) - '0');
					idx++;
				}
				countStack.offerFirst(count);
			} else if (c == '[') {
				resStack.offerFirst(res);
				res = "";
				idx++;
			} else if (c == ']') {
				StringBuilder temp = new StringBuilder (resStack.pollFirst());
				int repeatTimes = countStack.pollFirst();
				for (int i = 0; i < repeatTimes; i++) {
					temp.append(res);
				}
				res = temp.toString();
				idx++;
			} else {
				res += s.charAt(idx++);
			}
		}
		return res;
	}
}