import java.util.ArrayList;
import java.util.List;

public class ValidParenthesis {
	public static List<String> validParentheses(int n) {
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		dfs(n, n, sb, result);
		return result;
	}

	private static void dfs(int leftRemain, int rightRemain, StringBuilder sb, List<String> result) {
		if (leftRemain == 0 && rightRemain == 0) {
			System.out.println(sb.toString());
			result.add(sb.toString());
			return;
		}
		// add left parenthesis
		if (leftRemain > 0) {
			dfs(leftRemain - 1, rightRemain, sb.append("("), result);
			sb.deleteCharAt(sb.length() - 1);
		}
		// add right parenthesis
		if (leftRemain < rightRemain) {
			dfs(leftRemain, rightRemain - 1, sb.append(")"), result);
			//sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	public static void main(String[] args) {
		List<String> result = validParentheses(2);
		for (String s : result) {
			System.out.println(s);
		}
		System.out.println(0 % 1);
	}
}
