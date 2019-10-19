package finalexam;

/*
Given a string, we can insert at most one empty space between each pair of adjacent letters. 
Print all permutations of strings after insertions of empty spaces. 

Input: str = "ABC" 

Output: 
ABC
AB_C
A_BC
A_B_C
*/

public class PermutationWithSpace {
	// input: String
	// time: O(2^(n-1))  space: O(n)
	public void printPermutations(String input) {
		StringBuilder sb = new StringBuilder();
		dfs(input, 0, sb);
	}
	
	private void dfs(String input, int index, StringBuilder sb) {
		if (index == input.length() - 1) {
			sb.append(input.charAt(index));
			System.out.println(sb);
			sb.deleteCharAt(sb.length() - 1);
			return;
		}
		sb.append(input.charAt(index)); // add current character
		// add " "
		sb.append(" ");
		dfs(input, index + 1, sb);
		sb.deleteCharAt(sb.length() - 1);
		// not add " "
		dfs(input, index + 1, sb);
		sb.deleteCharAt(sb.length() - 1);
	}
}
