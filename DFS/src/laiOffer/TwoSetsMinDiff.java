package laiOffer;
import java.util.*;

public class TwoSetsMinDiff {
	public int minDifference(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		int[] min = new int[]{Integer.MAX_VALUE};
		List<Integer> list = new ArrayList<>();
		DFS(array, sum, 0, min, list);
		return min[0];
	}

	private void DFS(int[] array, int sum, int index, int[] min, List<Integer> list) {
		// base case
		if (list.size() == array.length / 2) {
			int setSum = calSum(list);
			int diff = Math.abs(setSum - (sum - setSum));
			min[0] = Math.min(min[0], diff);
			return;
		}
		if (index == array.length) {
			return;
		}
		list.add(array[index]);
		DFS(array, sum, index + 1, min, list);
		list.remove(list.size() - 1);
		DFS(array, sum, index + 1, min, list); 
	}

	private int calSum(List<Integer> list) {
		int sum = 0;
		for (int i : list) {
			sum += i;
		}
		return sum;
	}
}
