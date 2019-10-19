package laiOffer;

import java.util.ArrayList;
import java.util.List;

public class The99cents {
	
	public List<List<Integer>> combinations(int target, int[] coins) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> combo = new ArrayList<>();
		helper(target, coins, 0, combo, result);
		return result;  
	}

	private void helper(int moneyLeft, int[] coins, int level, List<Integer> combo, List<List<Integer>> result) {
		// found one appropriate combination
		if (level == coins.length && moneyLeft == 0) {
			result.add(new ArrayList<>(combo));
			return;
		} else if (level == coins.length && moneyLeft != 0) { // last coin is not enough
			return;
		}
		int coin = coins[level];
		for (int i = 0; i * coin <= moneyLeft; i++) {
			combo.add(i);
			helper(moneyLeft - i * coin, coins, level + 1, combo, result);
			combo.remove(combo.size() - 1);
		}  
	}

}
