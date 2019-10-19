package laiOffer;

public class CountAndSay {
	public String countAndSay(int n) {
		StringBuilder cur = new StringBuilder("1");
		StringBuilder prev;
		int count;
		char c;
		for (int i = 2; i <= n; i++) {
			prev = cur;
			cur = new StringBuilder();
			count = 1;            
			c = prev.charAt(0);
			for (int j = 1; j < prev.length(); j++) {
				if (prev.charAt(j) == c) {
					count++;
					continue;
				}
				cur.append(count).append(c);
				count = 1;
				c = prev.charAt(j);
			}
			cur.append(count).append(c);
		}
		return cur.toString();
	}
}
