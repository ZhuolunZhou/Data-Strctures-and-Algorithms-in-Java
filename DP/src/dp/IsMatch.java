package dp;

public class IsMatch {
	public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        } else if (p.equals("*")) {
            return true;
        }
        // M[i][j] represents whether s[i : ] matches p[j :]
        boolean[][] M = new boolean[s.length() + 1][p.length() + 1];
        M[s.length()][p.length()] = true;
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                if (i == s.length() && p.charAt(j) == '*') {
                	M[i][j] = M[i][j + 1];
                } else if (i == s.length()) {
                	continue;
                } else if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    M[i][j] = M[i + 1][j + 1];       	
                } else if (p.charAt(j) == '*') {
                    M[i][j] = M[i][j + 1] || M[i + 1][j];
                }
            }
        }
        return M[0][0];
    }
}
