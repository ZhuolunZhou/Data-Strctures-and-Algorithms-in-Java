package laiOffer;

import java.util.*;

public class StringReplace {
	//	public String replace(String input, String source, String target) {
	//		// corner case
	//		if (input.length() == 0) {
	//			return input;
	//		}
	//		if (source.length() >= target.length()) {
	//			return replaceShorter(input.toCharArray(), source, target);
	//		} else {
	//			return replaceLonger(input.toCharArray(), source, target);
	//		}
	//	}
	//	public String replaceShorter(char[] input, String s, String t) {
	//		int slow = 0;
	//		int fast = 0;
	//		while (fast < input.length) {
	//			if (fast <= input.length - t.length() && equalsString(input, fast, s)) {
	//				copySubString(input, slow, t);
	//				fast += s.length();
	//				slow += t.length();
	//			} else {
	//				input[slow++] = input[fast++];
	//			}
	//		}
	//		return new String(input, 0, slow);
	//	}
	//
	//	public String replaceLonger(char[] input, String s, String t) {
	//		List<Integer> matches = findMatches(input, s);
	//		char[] result = new char[input.length + matches.size() * (t.length() - s.length())];
	//		int lastIdx = matches.size() - 1;
	//		int fast = input.length - 1;
	//		int slow = result.length - 1;
	//		while (fast >= 0) {
	//			if (lastIdx >= 0 && fast == matches.get(lastIdx) + s.length() - 1) {
	//				copySubString(result, slow - t.length() + 1, t);
	//				slow -= t.length();
	//				fast -= s.length();
	//				lastIdx--;
	//			} else {
	//				result[slow--] = input[fast--];
	//			}
	//		}
	//		return new String(result);	
	//	}
	//
	//
	//	private List<Integer> findMatches(char[] input, String s) {
	//		List<Integer> result = new ArrayList<>();
	//		int i = 0; 
	//		while (i <= input.length - s.length()) {
	//			if (equalsString(input, i, s)) {
	//				result.add(i);
	//				i += s.length();
	//			} else {
	//				i++;
	//			}
	//		}
	//		return result;
	//	}
	//
	//	private boolean equalsString(char[] input, int index, String s) {
	//		for (int i = 0; i < s.length(); i++) {
	//			if (i + index >= input.length || input[i + index] != s.charAt(i)) {
	//				return false;
	//			}
	//		}
	//		return true;
	//	}
	//
	//	private void copySubString(char[] input, int index, String t) {
	//		for (int i = 0; i < t.length(); i++) {
	//			input[index + i] = t.charAt(i);
	//		}
	//	}
	public String replace(String input, String source, String target) {
		char[] inputArr = input.toCharArray();
		if (source.length() >= target.length()) {
			return replaceSmaller(inputArr, source, target);
		} else {
			return replaceLarger(inputArr, source, target);
		}
	}

	private String replaceSmaller(char[] inputArr, String source, String target) {
		int slow = 0;
		int fast = 0;
		while (fast < inputArr.length) {
			if (isSource(inputArr, fast, source)) {
				replace(inputArr, slow, target);
				fast += source.length();
				slow += target.length();
			} else {
				inputArr[slow++] = inputArr[fast++];
			}
		}
		return new String(inputArr, 0, slow);
	}

	private String replaceLarger(char[] inputArr, String source, String target) {
		List<Integer> indices = new ArrayList<>();
		int i = 0;
		// find all sources
		while (i <= inputArr.length - source.length()) {
			if (isSource(inputArr, i, source)) {
				indices.add(i);
				i += source.length();
			} else {
				i++;
			}
		}
		int newLen = inputArr.length + (target.length() - source.length()) * indices.size();
		char[] newArr = new char[newLen];
		int slow = newArr.length - 1;
		int fast = inputArr.length - 1;
		while (fast >= 0) {
			int index = indices.get(indices.size() - 1);
			if (index == fast - source.length() + 1) {
				replace(newArr, slow - target.length() + 1, target);
				indices.remove(indices.size() - 1);
				fast -= source.length();
				slow -= target.length();
			} else {
				newArr[slow--] = inputArr[fast--];
			}
		}
		return new String(newArr);
	}

	private boolean isSource(char[] array, int start, String source) {
		for (int i = 0; i < source.length(); i++) {
			if (start + i >= array.length || array[start + i] != source.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private void replace(char[] array, int slow, String target) {
		for (int i = 0; i < target.length(); i++) {
			array[slow + i] = target.charAt(i);
		}
	}

}
