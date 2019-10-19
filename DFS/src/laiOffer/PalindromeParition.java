package laiOffer;
import java.util.*;

public class PalindromeParition {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		if (s == null || s.length() == 0) return result;
		char[] array = s.toCharArray();
		List<String> cur = new ArrayList<>();
		dfs(array, 0, cur, result);
		return result;
	}

	// index is the start position of palindrome
	private void dfs(char[] array, int index, List<String> cur, List<List<String>> result) {
		if (index == array.length) {
			result.add(new ArrayList<>(cur));
			return;
		}
		for (int i = index; i < array.length; i++) { // i is the cut position
			if (isPalindrome(array, index, i)) {
				cur.add(new String(array, index, i - index + 1));
				dfs(array, i + 1, cur, result);
				cur.remove(cur.size() - 1);
			}
		}
	}

	private boolean isPalindrome(char[] array, int left, int right) {
		while (left < right) {
			if (array[left] != array[right]) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
