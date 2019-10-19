package laiOffer;
import java.util.*;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		if (!wordSet.contains(endWord)) {
			return 0;
		}
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		int length = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				String cur = queue.poll();
				if (cur.equals(endWord)) {
					return length + 1;
				}
				char[] charArr = cur.toCharArray();
				for (int i = 0; i < charArr.length; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char tmp = charArr[i];
						charArr[i] = c;
						String newStr = new String(charArr);
						charArr[i] = tmp;
						if (!newStr.equals(cur) && wordSet.contains(newStr)) {
							queue.offer(newStr);
							wordSet.remove(newStr);
						}
					}
				}
			}
			length++;
		}
		return 0;
	}
}
