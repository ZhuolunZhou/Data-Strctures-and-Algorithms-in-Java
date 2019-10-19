package laioffer;
import java.util.*;

public class LargestRect {
	public int largest(int[] array) {
		int result = 0;
		Deque<Integer> stack = new ArrayDeque<>(); // store index
		for (int i = 0; i <= array.length; i++) {
			int height = i == array.length ? 0 : array[i];
			while (!stack.isEmpty() && array[stack.peekFirst()] >= height) {
				int prev = array[stack.pollFirst()];
				int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
				result = Math.max(result, prev * (i - left));
			}
			stack.offerFirst(i);
		}
		return result;
	}
}
