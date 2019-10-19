package laiOffer;
import java.util.*;

public class IPAddress {
	public List<String> Restore(String ip) {
		List<String> result = new ArrayList<>();
		if (ip == null) {
			return result;
		}
		char[] array = ip.toCharArray();
		StringBuilder sb = new StringBuilder();
		helper(array, 0, 0, sb, result);
		return result;
	}

	private void helper(char[] array, int index, int left, StringBuilder sb, List<String> result) {
		if (index == 3) {
			if (left < array.length) {
				Integer num = convertToInt(array, left, array.length - 1);
				if (num != null && num <= 255) {
					for (int i = left; i <= array.length - 1; i++) {
						sb.append(array[i]);
					}
					result.add(sb.toString());
					for (int i = left; i <= array.length - 1; i++) {
						sb.deleteCharAt(sb.length() - 1);
					}
					return;
				}
			} 
		}
		// at most 3 digits per subip: left, [left, left + 1],  [left, left + 2]
		for (int i = 0; i < 3; i++) {
			if (left + i < array.length) {
				Integer num = convertToInt(array, left, left + i);
				if (num != null && num <= 255) {
					for (int j = 0; j <= i; j++) {
						sb.append(array[left + j]);
					}
					sb.append('.');
					helper(array, index + 1, left + i + 1, sb, result);
					sb.deleteCharAt(sb.length() - 1);
					for (int j = 0; j <= i; j++) {
						sb.deleteCharAt(sb.length() - 1);
					}
				}

			}
		}
	}

	private Integer convertToInt(char[] array, int left, int right) {
		Integer num = 0;
		boolean hasZero = false;
		for (int i = left; i <= right; i++) {
			if (hasZero) {
				return null;
			}
			if (array[left] == '0') {
				hasZero = true;
			} 
			num = num * 10 + (array[i] - '0');
		}
		return num;
	}
}
