package laiOffer;

public class ReverseWordsII {
	public String reverseWords(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		String newString = removeSpaces(input);
		return reverse(newString);
	}

	private String removeSpaces(String input) {
		char[] array = input.toCharArray();
		// [0, slow) are final result
		int slow = 0;
		for (int fast = 0; fast < array.length; fast++) {
			if (array[fast] == ' ' && (slow == 0 || array[slow - 1] == ' ')) {
				continue;
			} else {
				array[slow++] = array[fast];
			}
		}
		// post-processing
		if (array[slow - 1] == ' ') {
			slow--;
		}
		return new String(array, 0, slow);
	}

	private String reverse(String input) {
		char[] array = input.toCharArray();
		reverseHelper(array, 0, array.length - 1);
		int left = 0;
		for (int right = 0; right < array.length; right++) {
			if (array[right] == ' ') {
				reverseHelper(array, left, right - 1);
				left = right + 1;
			}
		}
		reverseHelper(array, left, array.length - 1);
		return new String(array);
	}

	private void reverseHelper(char[] array, int left, int right) {
		while (left < right) {
			char temp = array[left];
			array[left++] = array[right];
			array[right--] = temp;
		}
	}
}
