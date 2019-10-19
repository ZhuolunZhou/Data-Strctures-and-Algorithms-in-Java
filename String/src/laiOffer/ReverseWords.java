package laiOffer;

public class ReverseWords {
	public String reverseWords(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int left = 0;
		for (int right = 0; right < array.length; right++) {
			if (array[right] == ' ') {
				reverse(array, left, right - 1);
				left = right + 1;
			}
		}
		// reverse last word
		reverse(array, left, array.length - 1);
		reverse(array, 0, array.length - 1);
		return new String(array);
	}

	private void reverse(char[] array, int left, int right) {
		while (left < right) {
			char tmp = array[left];
			array[left++] = array[right];
			array[right--] = tmp;
		}
	}
}
