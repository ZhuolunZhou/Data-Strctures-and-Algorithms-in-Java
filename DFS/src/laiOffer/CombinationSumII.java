package laiOffer;
import java.util.*;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (num == null) {
			return result;
		}
		List<Integer> combo = new ArrayList<>();
		Arrays.sort(num); // non-descending order
		DFS(num, 0, target, combo, result);
		return result;
	}

	private void DFS(int[] num, int index, int remain, List<Integer> combo, List<List<Integer>> result) {
		if (remain == 0) {
			result.add(new ArrayList<Integer>(combo));
			return;
		}
		if (index >= num.length) {
			return;
		}
		int cur = num[index];
		// add cur
		combo.add(cur);
		DFS(num, index + 1, remain - cur, combo, result);
		combo.remove(combo.size() - 1);   
		// not add cur
		// de-duplication
		while (index + 1 < num.length && num[index + 1] == num[index]) {
			index++;
		}
		// num[index + 1] != num[index] || num[index] >= num.length - 1
		DFS(num, index + 1, remain, combo, result);
	}
}
