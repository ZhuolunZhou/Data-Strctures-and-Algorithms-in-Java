package laiOffer;
import java.util.*;

public class PermutationInString {
	public boolean containsPermutation(String s1, String s2) {
		// store the characters of s1 in map
		Map<Character, Integer> map = new HashMap<>();
		int count = 0; // records number of different characters in s1
		for (int i = 0; i < s1.length(); i++) {
			Integer num = map.get(s1.charAt(i));
			if (num == null) {
				map.put(s1.charAt(i), 1);
				count++;
			} else {
				map.put(s1.charAt(i), num + 1);
			}
		}
		int slow = 0;
//		for (int fast = 0; fast < s2.length(); fast++) {
//			// handle right border
//			Integer num = map.get(s2.charAt(fast));
//			if (num != null) {
//				map.put(s2.charAt(fast), num - 1);
//				if (num - 1 == 0) {
//					count--;
//				} else if (num == 0) {
//					count++;
//				}
//			}
//			// handle left border
//			if (fast >= s1.length()) {
//				Integer num2 = map.get(s2.charAt(slow));
//				if (num2 != null) {
//					map.put(s2.charAt(slow), num2 + 1);
//					if (num2 == 0) {
//						count++;
//					} else if (num2 == -1) {
//						count--;
//					}
//				}
//				slow++;
//			}
//			if (count == 0) {
//				return true;
//			}
//		}
		for (int fast = 0; fast < s2.length(); fast++) {
			// handle right border
			Integer num = map.get(s2.charAt(fast));
			if (num != null) {
				map.put(s2.charAt(fast), num - 1);
				if (num - 1 == 0) {
					count--;
				}
			}
			// handle left border
			if (fast >= s1.length()) {
				Integer num2 = map.get(s2.charAt(slow));
				if (num2 != null) {
					map.put(s2.charAt(slow), num2 + 1);
					if (num2 == 0) {
						count++;
					} 
				}
				slow++;
			}
			if (count == 0) {
				return true;
			}
		}
		return false;
	}
}






