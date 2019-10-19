package finalexam;

// Assumption: input num is larger than 1
public class SplitNumber {
	// time: O(n^1.5)  space: O(n)
	public int split(int num) {
		int[] M = new int[num + 1]; // M[i] represents the minimum cut for num i
		for (int i = 1; i <= num; i++) {
			M[i] = i; // for num i, at most cut i - 1 times
			for (int j = 1; j * j <= i; j++) { // 右小段
				M[i] = Math.min(M[i], M[i - j * j] + 1);
			}
		}
		return M[num];
	}
}
