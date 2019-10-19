package laiOffer;
import java.util.*;

public class WordSearchII {
	static final int[][] DIRS = {{-1,0},{1,0},{0,-1},{0,1}};
	public List<String> findWords(char[][] board, String[] words, boolean[][] visited) {
		List<String> result = new ArrayList<>();
		TrieNode root = buildTree(words); // build trie
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(root, board, i, j, sb, result, visited);
			}
		}
		return result;
	}

	// root denotes the TrieNode in the current level 
	private void dfs(TrieNode root, char[][] board, int x, int y, StringBuilder sb, 
			List<String> result, boolean[][] visited) {
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] ||
				root.children[board[x][y] - 'a'] == null) {
			return;
		}
		root = root.children[board[x][y] - 'a'];
		sb.append(board[x][y]);
		if (root.isWord) {
			result.add(sb.toString());
			root.isWord = false;
		}
		visited[x][y] = true;
		for (int[] dir : DIRS) {
			int neiX = x + dir[0];
			int neiY = y + dir[1];
			dfs(root, board, neiX, neiY, sb, result, visited);
		}
		visited[x][y] = false;
		sb.deleteCharAt(sb.length() - 1);
	}

	// store words in the Trie
	private TrieNode buildTree(String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			insert(root, word);
		}
		return root;
	}

	private void insert(TrieNode root, String word) {
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (root.children[index] == null) {
				root.children[index] = new TrieNode();
			}
			root = root.children[index];
		}
		root.isWord = true;
	}

	static class TrieNode {
		private boolean isWord;
		private TrieNode[] children;

		public TrieNode() {
			children = new TrieNode[26];
		}
	}
}
