package laioffer;
import java.util.*;

public class LargestSecondLargest {
	public int[] largestAndSecond(int[] array) {
		int n = array.length;
		Element[] helper = new Element[n];
		// store values to Element array
		for (int i = 0; i < n; i++) {
			helper[i] = new Element(array[i]);
		}
		while (n > 1) {
			compare(helper, n);
			n = (n + 1) / 2;
		}
		int secondLargest = helper[0].comparedValues.get(0);
		for (int i : helper[0].comparedValues) {
			secondLargest = Math.max(secondLargest, i);
		}
		return new int[]{helper[0].value, secondLargest};
	}

	private void compare(Element[] helper, int length) {
		for (int i = 0; i < length / 2; i++) {
			if (helper[i].value < helper[length - 1 - i].value) {
				swap(helper, i, length - 1 - i);
			}
			helper[i].comparedValues.add(helper[length - 1 - i].value);
		}
	}

	private void swap(Element[] array, int a, int b) {
		Element temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	static class Element {
		int value;
		List<Integer> comparedValues;
		public Element(int value) {
			this.value = value;
			comparedValues = new ArrayList<>();
		}
	}
}
