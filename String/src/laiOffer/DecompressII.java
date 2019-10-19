package laiOffer;

public class DecompressII {
	public String decompress(String input) {
		if (input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		// traverse from left to right to decompress occurrence <= 2
		int slow = 0, newLen = 0;
		for (int fast = 0; fast < array.length - 1; fast += 2) {
			char cur = array[fast];
			int num = convertToNum(array[fast + 1]);
			newLen += num;
			if (num <= 2) {
				for (int i = 0; i < num; i++) {
					array[slow++] = array[fast];
				}
			} else {
				array[slow++] = array[fast];
				array[slow++] = array[fast + 1];
			}
		}
		char[] newArr = newLen > array.length ? new char[newLen] : array;
		// traverse from right to left to decompress string
		slow--;
		int pointer = newLen - 1;
		while (pointer >= 0) {
			if (isNum(array[slow]) && slow > 0) {
				int num = convertToNum(array[slow]);
				for (int j = 0; j < num; j++) {
					newArr[pointer--] = array[slow - 1];
				}
				slow -= 2;
			} else {
				newArr[pointer--] = array[slow--];
			}
		}
		return new String(newArr, 0, newLen);
	}

	private int convertToNum(char c) {
		return c - '0';
	}

	private boolean isNum(char c) {
		return c >= '0' && c <= '9'; 
	}
}
