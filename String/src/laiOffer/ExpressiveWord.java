package laiOffer;

public class ExpressiveWord {
	public int expressiveWords(String S, String[] words) {
		if (S == null || words == null || words.length == 0) return 0;
		int count = 0;
		for (String s : words) {
			if (compare(S, s)) count++;   
		}
		return count;
	}

	private boolean compare(String s1, String s2) {
		if (s1.length() < s2.length()) return false;
		int p1 = 0, p2 = 0;
		while (p1 < s1.length() && p2 < s2.length()) {
			if (s1.charAt(p1) != s2.charAt(p2)) return false;
			int count1 = 1;
			while (p1 + 1 < s1.length() && s1.charAt(p1) == s1.charAt(p1 + 1)) {
				count1++;
				p1++;
			}
			int count2 = 1;
			while (p2 + 1 < s2.length() && s2.charAt(p2) == s2.charAt(p2 + 1)) {
				count2++;
				p2++;
			}
			if (count2 > count1 || (count2 < count1 && count1 < 3)) return false; 
			p1++;
			p2++;
		}
		return p1 == s1.length() && p2 == s2.length();
	}
}
