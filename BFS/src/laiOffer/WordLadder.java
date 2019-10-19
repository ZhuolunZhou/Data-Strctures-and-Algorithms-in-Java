package laiOffer;
import java.util.*;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// preprocessing
		Map<String, List<String>> map = getMap(wordList);
		Queue<String> queue = new ArrayDeque<>();
		Set<String> set = new HashSet<>();
		queue.offer(beginWord);
		set.add(beginWord);
		int length = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				if (cur.equals(endWord)) {
					return length + 1;
				}
				char[] array = cur.toCharArray();
				for (int j = 0; j < array.length; j++) {
					char tmp = array[j];
					array[j] = '*';
					String newStr = new String(array);
					array[j] = tmp;
					List<String> list = map.get(newStr);
					if (list != null) {
						for (String str : list) {
							if (set.add(str)) {
								queue.offer(str);
							}
						}
					}
				}
			}
			length++;
		}
		return 0;
	}

	private Map<String, List<String>> getMap(List<String> list) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : list) {
			char[] array = str.toCharArray();
			for (int i = 0; i < array.length; i++) {
				char tmp = array[i];
				array[i] = '*';
				String newStr = new String(array);
				array[i] = tmp;
				List<String> curList = map.getOrDefault(newStr, new ArrayList<String>());
				curList.add(str);
				map.put(newStr, curList);
			}
		}
		return map;
	}
}
