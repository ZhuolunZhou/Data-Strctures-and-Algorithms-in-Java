package trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {
	TrieNode root;

	Trie(String[] words) {
		root = new TrieNode();
		for (String s : words) {
			TrieNode cur = root;
			for (char c : s.toCharArray()) {
				int idx = c - 'a';
				if (cur.children[idx] == null) {
					cur.children[idx] = new TrieNode();
				}
				cur.children[idx].startWith.add(s);
				cur = cur.children[idx];
			}
		}
	}
	List<String> findByPrefix(String prefix) {
		List<String> ans = new ArrayList<>();
		TrieNode cur = root;
		for (char c : prefix.toCharArray()) {
			int idx = c - 'a';
			if (cur.children[idx] == null) return ans;
			cur = cur.children[idx];
		}
		ans.addAll(cur.startWith);
		return ans;
	}
}

class TrieNode {
	List<String> startWith;
	TrieNode[] children;

	TrieNode() {
		startWith = new ArrayList<>();
		children = new TrieNode[26];
	}
}