package finalexam;

public class Circle {
	// time: O(n!)  space: O(n)
	public boolean circle(String[] input) {
		return helper(input, 0);
	}
	
	private boolean helper(String[] input, int index) {
		if (index == input.length) {
			return (input[index - 1].charAt(input[index - 1].length() - 1) == input[0].charAt(0));
		}
		
		for (int i = index; i < input.length; i++) {
			// check whether it is valid to swap ith string
			if (index == 0 || input[index - 1].charAt(input[index - 1].length() - 1) == input[i].charAt(0)) {
				swap(input, index, i);
				if (helper(input, index + 1)) {
					return true;
				}
				swap(input, index, i);
			}
		}
		return false;
	}
	
	private void swap(String[] array, int a, int b) {
		String temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
