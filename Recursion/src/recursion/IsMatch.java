package recursion;

public class IsMatch {
	public boolean isMatch(String s, String p) {
		// M[i][j] represents whether s[i:] match p[j:]
		boolean[][] M = new boolean[s.length() + 1][p.length() + 1];
		M[s.length()][p.length()] = true;
		// scan bottom-up right-left
		for (int i = s.length(); i >= 0; i--) {
			for (int j = p.length() - 1; j >= 0; j--) {
				boolean match = i < s.length() &&
						(p.charAt(j) == s.charAt(i) ||
						p.charAt(j) == '.');
				if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
					M[i][j] = M[i][j + 2] || match && M[i + 1][j];
				} else {
					M[i][j] = match && M[i + 1][j + 1];
				}

			}
		}
		return M[0][0];
	}

}
