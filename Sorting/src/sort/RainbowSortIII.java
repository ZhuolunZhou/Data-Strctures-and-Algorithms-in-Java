package sort;

public class RainbowSortIII {
	public int[] rainbowSortIII(int[] array, int k) {
		if (array == null || array.length <= 1) {
			return array;
		}
		// index i represents color i, colors[i] represents the current index
		int[] colors = new int[k + 1];
		colors[k] = array.length - 1;
		while (colors[k - 1] <= colors[k]) {
			int color = array[colors[k - 1]];
			if (color < k - 1) {	
				swap(array, colors[color]++, colors[k - 1]);
				for (int j = color + 1; j <= k - 1; j++) {
					if (colors[j] < colors[color]) {
						colors[j]++;
					}
				}
			} else if (color == k - 1) {
				colors[k - 1]++;
			} else {
				swap(array, colors[k - 1], colors[k]--);
			}			
		}
		return array;
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
