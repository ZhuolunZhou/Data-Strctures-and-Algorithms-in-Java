package laiOffer;
import java.util.*;

public class Compress {
	//	“abbcccdeee” → “ab2c3de3”
	//	public String compress(String input) {
	//		if (input.length() == 0) {
	//			return input;
	//		}
	//		char[] array = input.toCharArray();
	//		List<Integer> helper = new ArrayList<>();
	//		int length = encodeShort(array, helper);
	//		return encodeLong(array, length, helper);
	//	}
	//	// iterate from left to right and handle case: [1, 9]
	//	public int encodeShort(char[] input, List<Integer> helper) {
	//		int slow = 0;
	//		int count = 1;
	//		for (int i = 1; i < input.length; i++) {
	//			if (input[i] == input[slow]) {
	//				count++;
	//			} else if (count == 1) {
	//				input[++slow] = input[i];
	//			} else if (count <= 9) {
	//				input[++slow] = convert(count);
	//				input[++slow] = input[i];
	//				count = 1;
	//			} else {
	//				helper.add(count);
	//				count = 1;
	//				input[++slow] = '*';
	//				input[++slow] = input[i];
	//			}
	//		}
	//		if (count > 1 && count <= 9) {
	//			input[++slow] = convert(count);
	//		} else if (count > 9) {
	//			input[++slow] = '*';
	//			helper.add(count);
	//		}
	//		slow++;
	//		//return new String(input, 0, slow);
	//		return slow;
	//	}
	//	
	//	// handle counts > 9
	//	public String encodeLong(char[] input, int length, List<Integer> helper) {
	//		int newLength = length;
	//		for (int i = 0; i < helper.size(); i++) {
	//			newLength += countDigits(helper.get(i)) - 1;
	//		}
	//		char[] result = new char[newLength];
	//		int end = newLength - 1;
	//		int pointer = length - 1;
	//		while (pointer >= 0) {
	//			if (input[pointer] == '*') {
	//				int num = helper.remove(helper.size() - 1);
	//				int digits = countDigits(num);
	//				char[] arr = getChar(num, digits);
	//				for (int i = arr.length - 1; i >= 0; i--) {
	//					result[end--] = arr[i];
	//				}
	//				pointer--;
	//			} else {
	//				result[end--] = input[pointer--];
	//			}
	//		}
	//		return new String(result);
	//	}
	//
	//	// convert int to char
	//	private char convert(int a) {
	//		return (char) (a + 48);
	//	}
	//	// count number of digits in an integer
	//	private int countDigits(int a) {
	//		int digits = 0;
	//		while (a > 0) {
	//			a /= 10;
	//			digits++;
	//		}
	//		return digits;
	//	}
	//	// convert an integer to a char array
	//	private char[] getChar(int a, int num) {
	//		char[] result = new char[num];
	//		for (int i = num - 1; i >= 0; i--) {
	//			result[i] = convert(a % 10);
	//			a /= 10;
	//		}
	//		return result;
	//	}

	public String compress(String input) {
		if (input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		int anchor = 0, slow = 0, newLen = 0;
		// compress characters which repeated occurrences > 1
		for (int fast = 0; fast < array.length; fast++) {
			if (fast + 1 >= array.length || array[fast] != array[fast + 1]) {
				newLen++;
				int count = fast - anchor + 1;
				array[slow++] = array[fast];
				if (count > 1) {
					for (char c : ("" + count).toCharArray()) {
						array[slow++] = c;
						newLen++;
					}
				} else {
					newLen++;
				}
				anchor = fast + 1;
			}
		}
		// compress characters which has only one occurrence
		char[] newArr = newLen > array.length ? new char[newLen] : array;
		slow--;
		for (int i = newLen - 1; i >= 0; i--) {
			if (!isChar(array[slow]) || slow + 1 < array.length && !isChar(array[slow + 1])) {
				newArr[i] = array[slow--];
			} else {
				newArr[i--] = '1';
				newArr[i] = array[slow--];
			}
		}
		return new String(newArr, 0, newLen);
	}

	private boolean isChar(char c) {
		return c >= 97 && c <= 97 + 26 - 1;
	}
}
