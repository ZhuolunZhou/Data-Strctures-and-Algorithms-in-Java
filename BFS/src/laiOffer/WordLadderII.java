package laiOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) {
            return res;
        }
        Map<String, List<String>> map = getChildren(beginWord, endWord, dict); // build graph
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, map, res, path); // dfs
        return res;
        
    }
    
    public void dfs(String beginWord, String endWord, Map<String, List<String>> map, List<List<String>> res, List<String> path) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
        }
        if (!map.containsKey(beginWord)) {
            return;
        }
        for (String child : map.get(beginWord)) {
            path.add(child);
            dfs(child, endWord, map, res, path);
            path.remove(path.size() - 1);
        }
    }
    
    // use set to perform BFS, set stores the elements in the current level
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
            if (start.size() > end.size()) { // always expand the smaller set
                Set<String> tmp = start;
                start = end;
                end = tmp;
                isBackward = !isBackward;
            }
            Set<String> set = new HashSet<>(); // store strings with one transformation
            for (String cur : start) {
                visited.add(cur);
                for (String next : getNext(cur, dict)) {
                    if (visited.contains(next) || start.contains(next)) { // de-dup
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
    
    // find all edges 
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
