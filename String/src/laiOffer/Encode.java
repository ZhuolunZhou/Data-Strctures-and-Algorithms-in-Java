package laiOffer;
public class Encode {
//	aabcccdddd -> a2b1c3d4
	public String compress(String input) {
		if (input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		int length = encodeShort(array);
		return encodeLong(array, length);	
	}
	// iterate from left to right and handle case: > 1
	public int encodeShort(char[] input) {
		int slow = 0;
		int count = 1;
		for (int i = 1; i < input.length; i++) {
			if (input[i] == input[slow]) {
				count++;
			} else if (count == 1) {
				input[++slow] = input[i];
			} else {
				input[++slow] = convert(count);
				input[++slow] = input[i];
				count = 1;
			}
		}
		if (count != 1) {
			input[++slow] = convert(count);
		}
		slow++;
		return slow;
	}
	
	// calculate new length, iterate from right to left and add 1 after the single character
	public String encodeLong(char[] input, int length) {
		int newLength = length;
		for (int i = length - 1; i >= 0; i--) {
			if (!isDigit(input[i])) {
				newLength++;
			} else {
				i--;
			}
		}
		char[] result = new char[newLength];
		int pointer = length - 1;
		int end = newLength - 1;
		while (pointer >= 0) {
			if (isDigit(input[pointer])) {
				result[end--] = input[pointer--];
				result[end--] = input[pointer--];
			} else {
				result[end--] = convert(1);
				result[end--] = input[pointer--];
			}
		}
		return new String(result);
	}
	// convert int to char
	private char convert(int a) {
		return (char) (a + 48);
	}
	// determine whether is number from 0 - 9
	private boolean isDigit(char a) {
		return (a >= 48 && a <= 48 + 9) ? true : false;
	}
}
