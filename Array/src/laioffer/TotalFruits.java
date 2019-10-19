package laioffer;

public class TotalFruits {
	public int totalFruit(int[] tree) {
		// find the longest window that contains only two unique numbers
		if (tree == null || tree.length == 0) return 0;
		int fruit1 = -1, fruit2 = -1, lastIdx1 = -1, lastIdx2 = -1, left = 0;
		int longest = 0;
		for (int right = 0; right < tree.length; right++) {
			int cur = tree[right];
			if (cur != fruit1 && cur != fruit2) { 
				longest = Math.max(longest, right - left);
				if (lastIdx1 <= lastIdx2) {
					// abandon origin fruit1
					fruit1 = cur;
					left = lastIdx1 + 1;
					lastIdx1 = right;
				} else {
					fruit2 = cur;
					left = lastIdx2 + 1;
					lastIdx2 = right;
				}
			} else if (cur != fruit1) {
				lastIdx2 = right;
			} else if (cur != fruit2) {
				lastIdx1 = right;
			} 
		}
		longest = Math.max(longest, tree.length - left);
		return longest;
	}
}
