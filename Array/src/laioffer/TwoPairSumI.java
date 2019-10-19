package laioffer;
import java.util.*;

public class TwoPairSumI {
	public List<List<Integer>> allPairs(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			List<Integer> indices = map.get(target - array[i]);
			if (indices != null) {
				for (int index : indices) {
					result.add(Arrays.asList(index, i));
				}
			}
			// add all possible indices for current value
			List<Integer> list = map.getOrDefault(array[i], new ArrayList<>());
			list.add(i);
			map.put(array[i], list);
		}
		return result;
	}
}
