package laiOffer;
import java.util.*;

public class findSubstring {
	//	public List<Integer> find(String s, String[] words) {
	//		List<Integer> result = new ArrayList<>();
	//		// corner case
	//		if (s == null || s.length() == 0 || words == null || words.length == 0) return result;
	//		Set<String> set = new HashSet<>(); // store all the combinations of words
	//		StringBuilder sb = new StringBuilder();
	//		dfs(words, 0, sb, set);
	//		for (String str : set) System.out.println(str);
	//		int length = words.length * words[0].length();
	//		for (int i = 0; i <= s.length() - length; i++) {
	//			if (set.contains(s.substring(i, i + length))) {
	//				result.add(i);
	//			}
	//		}
	//		return result;
	//	}
	//
	//	private void dfs(String[] words, int index, StringBuilder sb, Set<String> set) {
	//		if (index == words.length) {
	//			set.add(sb.toString());
	//			return;
	//		}
	//		// index represents the current index to figure out
	//		for (int i = index; i < words.length; i++) {
	//			// i represents the which idx of word can be places in current index
	//			swap(words, i, index);
	//			sb.append(words[index]);
	//			System.out.println(sb.toString());
	//			dfs(words, index + 1, sb, set);
	//			sb.delete(sb.length() - words[index].length(), sb.length());
	//			System.out.println(sb.toString());
	//			swap(words, i, index);
	//		}
	//	}
	//
	//	private void swap(String[] array, int a, int b) {
	//		String temp = array[a];
	//		array[a] = array[b];
	//		array[b] = temp;
	//	}

	public List<Integer> find(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		int n = s.length(), length = words.length, wordLen;
		if (n == 0 || length == 0 || (wordLen = words[0].length()) == 0) return res;

		Map<String, Integer> dict = new HashMap<>();
		for (String word : words) 
			dict.put(word, dict.getOrDefault(word, 0) + 1);

		Map<String, Integer> curdict = new HashMap<>();

		int start = 0, totalLen = length * wordLen;
		String test, tmp;
		for (int i = 0; i < wordLen; i++) {
			curdict.clear();
			start = i;
			if (start + totalLen > n) return res;
			for (int j = i; j + wordLen <= n; j += wordLen) {
				test = s.substring(j, j + wordLen);
				if (dict.containsKey(test)) {
					if (!curdict.containsKey(test) || curdict.get(test) < dict.get(test)) {
						curdict.put(test, curdict.getOrDefault(test, 0) + 1);
						if (start + totalLen == j + wordLen) {
							res.add(start);

							// remove s.substring(start, start + wordLen)
							decreaseCount(curdict, s.substring(start, start + wordLen));

							// move window to right, move start to start + wordLen
							start += wordLen;
						}
						continue;
					}

					// if curdict.get(test) == dict.get(test)
					// find the first substring that equals test 
					while (!(tmp = s.substring(start, start + wordLen)).equals(test)) {
						decreaseCount(curdict, tmp);
						start += wordLen;
					}
					// and skip one substring that equals test
					start += wordLen;
					if (start + totalLen > n) break;
					continue;
				}
				// if dict not contains test, move start wordLen steps right
				start = j + wordLen;
				if (start + totalLen > n) break;
				curdict.clear();
			}
		}
		return res;
	}

	private void decreaseCount(Map<String ,Integer> curdict, String tmp) {
		if (curdict.get(tmp) == 1) 
			curdict.remove(tmp);
		else 
			curdict.put(tmp, curdict.get(tmp) - 1);
	}
}
