package laiOffer;
import java.util.*;

public class WordLadderII {
//	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//		Map<String, List<String>> graph = new HashMap<>();
//		buildGraph(graph, wordList);
//		// dfs
//		Map<Integer, List<List<String>>> allLadders = new HashMap<>();
//		List<String> path = new ArrayList<>();
//		path.add(beginWord);
//		int[] min = {wordList.size() + 1};
//		dfs(beginWord, endWord, 2, min, allLadders, path, graph);
//		return allLadders.getOrDefault(min[0], new ArrayList<>());
//	}
//
//	private void dfs(String cur, String target, int length, int[] min, Map<Integer, List<List<String>>> map,                                      List<String> path, Map<String, List<String>> graph) {
//		if (length > min[0]) return;
//		if (cur.equals(target)) {
//			min[0] = length;
//			List<List<String>> ls = map.getOrDefault(length, new ArrayList<>());
//			ls.add(new ArrayList<>(path));
//			map.put(length, ls);
//			return;
//		}
//		char[] arr = cur.toCharArray();
//		for (int i = 0; i < arr.length; i++) {
//			char tmp = arr[i];
//			arr[i] = '*';
//			String newStr = String.valueOf(arr);
//			arr[i] = tmp;
//			List<String> neighbors = graph.get(newStr);
//			if (neighbors != null) {
//				for (String s : neighbors) {
//					path.add(s);
//					dfs(s, target, length + 1, min, map, path, graph);
//					path.remove(path.size() - 1);
//				}
//			}
//		}
//	}
//
//	public void buildGraph(Map<String, List<String>> map, List<String> wordList) {
//		for (String str : wordList) {
//			char[] arr = str.toCharArray();
//			for (int i = 0; i < arr.length; i++) {
//				char tmp = arr[i];
//				arr[i] = '*';
//				String newStr = String.valueOf(arr);
//				arr[i] = tmp;
//				List<String> list = map.getOrDefault(newStr, new ArrayList<>());
//				list.add(str);
//				map.put(newStr, list);
//			}
//		}
//	}
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) {
            return res;
        }
        Map<String, List<String>> map = getChildren(beginWord, endWord, dict);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        findLadders(beginWord, endWord, map, res, path);
        return res;
        
    }
    
    public void findLadders(String beginWord, String endWord, Map<String, List<String>> map, List<List<String>> res, List<String> path) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
        }
        if (!map.containsKey(beginWord)) {
            return;
        }
        for (String next : map.get(beginWord)) {
            path.add(next);
            findLadders(next, endWord, map, res, path);
            path.remove(path.size() - 1);
        }
    }
    
    public Map<String, List<String>> getChildren(String beginWord, String endWord, Set<String> dict) {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> start = new HashSet<>();
        start.add(beginWord);
        Set<String> end = new HashSet<>();
        end.add(endWord);
        Set<String> visited = new HashSet<>();
        boolean found = false;
        boolean isBackward = false;
        while (!start.isEmpty() && !found) {
            if (start.size() > end.size()) {
                Set<String> tmp = start;
                start = end;
                end = tmp;
                isBackward = !isBackward;
            }
            Set<String> set = new HashSet<>();
            for (String cur : start) {
                visited.add(cur);
                for (String next : getNext(cur, dict)) {
                    if (visited.contains(next) || start.contains(next)) {
                        continue;
                    }
                    if (end.contains(next)) {
                        found = true;
                    }
                    set.add(next);
                    String parent = isBackward ? next : cur;
                    String child = isBackward ? cur : next;
                    if (!map.containsKey(parent)) {
                        map.put(parent, new ArrayList<>());
                    }
                    map.get(parent).add(child);
                    
                }
            }
            start = set;
        }
        return map;
        
    }
    private List<String> getNext(String cur, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] chars = cur.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char tmp = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == tmp) {
                    continue;
                }
                chars[i] = c;
                String next = new String(chars);
                if (dict.contains(next)) {
                    res.add(next);
                }
            }
            chars[i] = tmp;
        }
        return res;
    }
}
