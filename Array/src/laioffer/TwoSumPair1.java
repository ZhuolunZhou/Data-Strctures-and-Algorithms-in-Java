package laioffer;
import java.util.*;

public class TwoSumPair1 {
	public List<List<Integer>> allPairs(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<Integer, List<Integer>> lookup = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (lookup.containsKey(target - array[i])) { // found pairs
				List<Integer> list = lookup.get(target - array[i]);
				for (int idx : list) {
					List<Integer> cur = new ArrayList<>();
					cur.add(idx);
					cur.add(i);
					result.add(cur);
				}
			}
			List<Integer> temp = lookup.get(array[i]);
			if (temp == null) {
				temp = new ArrayList<>();
			}
			temp.add(i);
			lookup.put(array[i], temp);
		}
		return result;
	}
}
