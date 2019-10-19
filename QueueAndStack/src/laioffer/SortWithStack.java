package laioffer;
import java.util.*;

public class SortWithStack {
	public Deque<Integer> sort(Deque<Integer> input) {
		Deque<Integer> output = new ArrayDeque<>();
		// pop all the elements and push to the output stack
		// record the global min
		while (!input.isEmpty()) {
			int globalMin = Integer.MAX_VALUE;
			int size = input.size();
			while (!input.isEmpty()) {
				int cur = input.pollFirst();
				globalMin = Math.min(globalMin, cur);
				output.offerFirst(cur);
			}
			for (int i = 0; i < size; i++) {
				int cur = output.pollFirst();
				if (cur != globalMin) {
					input.offerFirst(cur);
				}
			}
			output.offerFirst(globalMin);
		}
		return output;
	}
}
