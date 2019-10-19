package laiOffer;
import java.util.*;

public class MinWindow {
//	public String minWindow(String s, String t) {
//		// corner case
//		if (s == null || t == null || s.isEmpty() || t.isEmpty()) return "";
//		Map<Character, Integer> map = new HashMap<>();
//		int count = getMap(t, map);
//		int min = s.length() + 1;
//		int start = 0;
//		int left = 0, right = -1;
//		// find a window [left, right] contains all characters in T
//		while (right < s.length()) {
//			if (count != 0) { // current window is not valid
//				right++;
//				if (right == s.length()) break;
//				Integer freq = map.get(s.charAt(right));
//				if (freq != null) {
//					map.put(s.charAt(right), --freq);
//					if (freq == 0) {
//						count--;
//					}
//				}
//			} else { // found a valid window, try to shrink window size
//				if (right - left + 1 < min) {
//					min = right - left + 1;
//					start = left;
//				}
//				Integer freq2 = map.get(s.charAt(left));
//				if (freq2 != null) {
//					if (freq2 == 0) {
//						count++;
//					}
//					map.put(s.charAt(left), ++freq2);
//				}
//				left++;
//			}          
//		}
//		if (min == s.length() + 1) return "";
//		return s.substring(start, start + min);
//	}
//
//	private int getMap(String t, Map<Character, Integer> map) {
//		int count = 0;
//		for (char c : t.toCharArray()) {
//			Integer freq = map.get(c);
//			if (freq == null) {
//				freq = 0;
//				count++;
//			} 
//			map.put(c, freq + 1);
//		}
//		return count;
//	}
	
//	public String minWindow(String s, String t) {
//		// corner case
//		if (s == null || t == null || s.isEmpty() || t.isEmpty()) return "";
//		Map<Character, Integer> map = new HashMap<>(); // key: char  value: occurrence
//		int count = getMap(t, map); // count distinct characters of t
//		int min = s.length() + 1;
//		int start = 0;
//		int left = 0, right = 0;
//		// find a window [left, right] contains all characters in T
//		while (right < s.length() || count == 0) {
//            if (count != 0) {
//                // add right
//                char c = s.charAt(right);
//                right++;
//                if (map.containsKey(c)) {
//                    Integer freq = map.get(c);
//                    freq--;
//                    if (freq == 0) {
//                        count--;
//                    }
//                    map.put(c, freq);
//                }
//            } else { // found a valid window
//                if (right - left < min) {
//                    start = left;
//                    min = right - left;
//                }
//                // we want to shrink window size to find a smaller valid window
//                char cLeft = s.charAt(left++);
//                if (map.containsKey(cLeft)) {
//                    Integer freq2 = map.get(cLeft);
//                    if (freq2 == 0) {
//                        count++;
//                    }
//                    map.put(cLeft, freq2 + 1);
//                }
//            }
//        }
//        if (min == s.length() + 1) return ""; // not found
//        return s.substring(start, start + min);
//	}
//
//	private int getMap(String t, Map<Character, Integer> map) {
//		int count = 0;
//		for (char c : t.toCharArray()) {
//			Integer freq = map.get(c);
//			if (freq == null) {
//				freq = 0;
//				count++;
//			} 
//			map.put(c, freq + 1);
//		}
//		return count;
//	}
	
	public String minWindow(String s, String t) {
		// corner case
		if (s == null || t == null || s.isEmpty() || t.isEmpty()) return "";
		Map<Character, Integer> map = new HashMap<>(); // key: char  value: occurrence
		getMap(t, map); 
        int count = map.size(); // count distinct characters of t
		int min = s.length() + 1;
		int start = 0;
		int left = 0, right = 0;
		// find a window [left, right] contains all characters in T
		while (right < s.length() || count == 0) {
            if (count != 0) {
                // add right
                char c = s.charAt(right);
                if (map.containsKey(c)) {
                    Integer freq = map.get(c);
                    freq--;
                    if (freq == 0) {
                        count--;
                    }
                    map.put(c, freq);
                    right++;
                }
            } else { // found a valid window
                if (right - left < min) {
                    start = left;
                    min = right - left;
                }
                // we want to shrink window size to find a smaller valid window
                char cLeft = s.charAt(left++);
                if (map.containsKey(cLeft)) {
                    Integer freq2 = map.get(cLeft);
                    if (freq2 == 0) {
                        count++;
                    }
                    map.put(cLeft, freq2 + 1);
                }
            }
        }
        if (min == s.length() + 1) return ""; // not found
        return s.substring(start, start + min);
	}

	private void getMap(String t, Map<Character, Integer> map) {
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
	}
}
