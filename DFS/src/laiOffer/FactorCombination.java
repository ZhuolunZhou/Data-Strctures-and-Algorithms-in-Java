package laiOffer;
import java.util.*;

public class FactorCombination {
	public List<List<Integer>> combinations(int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> factors = findFactors(target);
		Collections.sort(factors);
		List<Integer> combo = new ArrayList<>();
		helper(factors, 0, 1, target, combo, result);
		return result;
	}

	private void helper(List<Integer> factors, int idx, int cur, int target, List<Integer> combo, List<List<Integer>> result) {
		if (cur == target) {
			result.add(new ArrayList<>(combo));
			return;
		} else if (cur > target || idx == factors.size()) {
	
			return;
		}
		int factor = factors.get(idx);
		// not multiply current factor
		helper(factors, idx + 1, cur, target, combo, result);
		// multiply current factor
		int count = 0;
		while (cur <= target) {
			cur *= factor;
			count++;
			for (int i = 0; i < count; i++) {
				combo.add(factor);
			}
			helper(factors, idx + 1, cur, target, combo, result);
			for (int i = 0; i < count; i++) {
				combo.remove(combo.size() - 1);
			}
		}
		
	}

	private List<Integer> findFactors(int target) {
		List<Integer> factors = new ArrayList<>();
		for (int i = 2; i * i <= target; i++) {
			if (target % i == 0) {
				factors.add(i);
				if (i != target / i) {
					factors.add(target / i);
				}
			}
		}
		return factors;
	}
}
