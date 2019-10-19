package laiOffer;
import java.util.*;

public class LargestProduct {
	public int largestProduct(String[] dict) {
		if (dict == null || dict.length < 2) {
			return 0;
		}
		Map<String, Integer> map = getBitMask(dict);
		Arrays.sort(dict, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return 0;
				}
				return s1.length() > s2.length() ? -1 : 1;
			}
		});
		for (String s : dict) {
			System.out.print(s + " ");
			System.out.println();
		}
		int largest = 0;
		// two arrays are sorted by lengths
		for (int i = 0; i < dict.length; i++) {
			for (int j = i + 1; j < dict.length; j++) {
				if (dict[i].length() * dict[j].length() < largest) {
					break;
				}
				if ((map.get(dict[i]) & map.get(dict[j])) == 0) {
					largest = Math.max(largest, dict[i].length() * dict[j].length());
				}
			}
		}
		return largest;
	}
	
	private Map<String, Integer> getBitMask(String[] dict) {
		Map<String, Integer> map = new HashMap<>();
		for (String s : dict) {
			int bitMask = 0;
			for (int i = 0; i < s.length(); i++) {
				bitMask |= 1 << s.charAt(i);
			}
			map.put(s, bitMask);
		}
		return map;
	}
}
