package dp;
import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {
	public int oddEvenJumps(int[] A) {
		int n = A.length, result = 1;
		boolean[] higher = new boolean[n], lower = new boolean[n];
		higher[n - 1] = lower[n - 1] = true;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(A[n - 1], n - 1); // key: A[i]  value: i
		for (int i = n - 2; i >= 0; i--) {
			Map.Entry<Integer, Integer> high = map.ceilingEntry(A[i]), low = map.floorEntry(A[i]);
			if (high != null) {
				higher[i] = lower[high.getValue()];
				if (higher[i]) result++;
			}
			if (low != null) lower[i] = higher[low.getValue()];
			map.put(A[i], i);
		}
		return result;
	}
}


