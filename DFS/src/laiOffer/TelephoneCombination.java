package laiOffer;
import java.util.*;

public class TelephoneCombination {
	public String[] combinations(int number) {
		List<Integer> numbers = getNumbers(number);
		Map<Integer, String> map = getMap();
		StringBuilder sb = new StringBuilder();
		List<String> rs = new ArrayList<>();
		helper(numbers, 0, sb, map, rs);
		String[] result = rs.toArray(new String[rs.size()]);
		return result;
	}

	private void helper(List<Integer> numbers, int idx, StringBuilder sb, 
			Map<Integer, String> map, List<String> rs) {
		if (idx == numbers.size()) {
			rs.add(sb.toString());
			return;
		}
		int number = numbers.get(idx);
		String str = map.get(number);
		if (str.length() == 0) {
			helper(numbers, idx + 1, sb, map, rs);
		} else {
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				helper(numbers, idx + 1, sb.append(c), map, rs);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	private Map<Integer, String> getMap() {
		Map<Integer, String> map = new HashMap<>();
		map.put(0, "");
		map.put(1, "");
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		return map;
	}

	private List<Integer> getNumbers(int number) {
		List<Integer> list = new ArrayList<>();
		if (number == 0) {
			list.add(0);
			return list;
		}
		while (number > 0) {
			list.add(number % 10);
			number /= 10;
		}
		Collections.reverse(list);
		return list;
	}
}
