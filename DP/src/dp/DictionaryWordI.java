package dp;

public class DictionaryWordI {
	public boolean canBreak(String input, String[] dict) {
		// M[i] is whether substring from 0 to i of input can be decomposed by words in dictionary
		boolean[] M = new boolean[input.length()];
		for (int i = 0; i < input.length(); i++) { 
			boolean check = false;
			for (int j = 0; j < i; j++) {
				String right = input.substring(j + 1, i + 1);
				check = check || M[j] && contains(dict, right);
			}
			check = check || contains(dict, input.substring(0, i + 1));
			M[i] = check;
		}
		return M[input.length() - 1];
	}

	private boolean contains(String[] array, String target) {
		for (String s : array) {
			if (s.equals(target)) {
				return true;
			}
		}
		return false;
	}
}
