package laiOffer;
import java.util.*;

public class Combinations {
	public List<List<Integer>> combine(int[] array, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> combo = new ArrayList<>();
		if (k == 0) {
			return result;
		}
		combine(array, k, 0, 0, combo, result);
		return result;
	}
	// index records the leftmost available index 
	private void combine(int[] array, int k, int level, int index, List<Integer> combo, List<List<Integer>> result) {
		if (combo.size() == k) {
			result.add(new ArrayList<Integer>(combo));
		}
		if (level == array.length) {
			return;
		}
		for (int i = index; i < array.length; i++) {
			combo.add(array[i]);
			combine(array, k, level + 1, i + 1, combo, result);
			combo.remove(combo.size() - 1);
		}
	}
}
