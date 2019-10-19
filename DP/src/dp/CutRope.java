package dp;

public class CutRope {
	// Method 1: 左大段 右大段
	//	public int maxProduct(int length) {
	//		int[] M = new int[length + 1]; // M[i] represents the max product of rope length i
	//		for (int i = 2; i <= length; i++) { // i is the rope length
	//			int max = 0;
	//			for (int j = 1; j <= i / 2; j++) { // j is cut-off rope length
	//				max = Math.max(max, Math.max(j, M[j]) * Math.max(i - j, M[i - j]));
	//			}
	//			M[i] = max;
	//		}
	//		return M[length];
	//	}

	// Method 2: 左大段 右小段
	public int maxProduct(int length) {
		int[] M = new int[length + 1]; // M[i] represents the max product of rope length i
		for (int i = 2; i <= length; i++) { // i is the rope length
			int max = 0;
			for (int j = 1; j < length; j++) { // j is cut-off rope length
				max = Math.max(max, Math.max(j, M[j]) * (i - j));
			}
			M[i] = max;
		}
		return M[length];
	}
}


