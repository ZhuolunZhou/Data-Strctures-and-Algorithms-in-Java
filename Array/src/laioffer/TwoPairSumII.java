package laioffer;
import java.util.*;

public class TwoPairSumII {
	public List<List<Integer>> allPairs(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : array) {
			if (map.containsKey(target - i)) {
				Integer count = map.get(target - i);
				if (count == 0) {
					result.add(Arrays.asList(i, target - i));
					map.put(target - i, count + 1);
				}
			} else {
				map.put(i, 0);
			}

		}
		return result;
	}
}
