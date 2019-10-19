package laiOffer;

public class Decode {
	//	public String decompress(String input) {
	//		if (input.length() == 0) {
	//			return input;
	//		}
	//		char[] array = input.toCharArray();
	//		return decodeLong(array, decodeShort(array));
	//	}
	//
	//
	//	private int decodeShort(char[] input) {
	//		int end = 0;
	//		for (int i = 0; i < input.length; i+=2) {
	//			int digit = convertChar(input[i + 1]);
	//			if (digit >= 0 && digit <= 2) {
	//				for (int j = 0; j < digit; j++) {
	//					input[end++] = input[i];
	//				}
	//			} else {
	//				input[end++] = input[i];
	//				input[end++] = input[i + 1];
	//			}
	//		}
	//		return end;
	//	}
	//
	//	private String decodeLong(char[] input, int length) {
	//		int newLength = length;
	//		for (int i = 0; i < length; i++) {
	//			int digit = convertChar(input[i]);
	//			if (digit > 2 && digit <= 9) {
	//				newLength += digit - 2;
	//			}
	//		}
	//		char[] result = new char[newLength];
	//		int end = newLength - 1;
	//		for (int i = length - 1; i >= 0; i--) {
	//			int digit = convertChar(input[i]);
	//			if (digit > 2 && digit <= 9) {
	//				i--;
	//				for (int j = 0; j < digit; j++) {
	//					result[end--] = input[i];
	//				}
	//			} else {
	//				result[end--] = input[i];
	//			}
	//		}
	//		return new String(result);
	//	}
	//
	//	public int convertChar(char a) {
	//		return a - '0'; 
	//	}
	public String decompress(String input) {
		// scan from left to right to decompress single char and calculate 
		// total length of new char[]
		char[] array = input.toCharArray();
		int slow = 0;
		int len = 0;
		for (int fast = 0; fast + 1 < array.length; fast+=2) {
			int num = getDigit(array[fast + 1]);
			len += num;
			if (num <= 2) {
				for (int i = 1; i <= num; i++) {
					array[slow++] = array[fast];
				}
			} else {
				array[slow++] = array[fast];
				array[slow++] = array[fast + 1];
			}
		}
		char[] newArr = len > array.length ? new char[len] : array;
		// [0, slow) has decopressed characters <= 1
		int i = len - 1;
		int j = slow - 1;
		while (j >= 0) {
			if (isChar(array[j])) {
				newArr[i--] = array[j--];
			} else {
				int num = getDigit(array[j]);
				for (int k = 1; k <= num; k++) {
					newArr[i--] = array[j - 1];
				}
				j -= 2;
			}
		}
		return new String(newArr, 0, len);  
	}

	private int getDigit(char c) {
		return c - '0';
	}

	private boolean isChar(char c) {
		return c >= 'a' && c <= 'z';
	}
}
