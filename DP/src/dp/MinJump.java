package dp;

public class MinJump {
//	public int minJump(int[] array) {
//		int[] M = new int[array.length];
//		for (int i = array.length - 2; i >= 0; i--) {
//			int steps = array[i];
//			M[i] = -1; // initialize all indices cannot jump to the end of the array
//			int j = 1;
//			int min = Integer.MAX_VALUE;
//			while (i + j <= array.length - 1 && j <= steps) {
//				if (M[i + j] == -1) {
//					j++;
//					continue;
//				} else {
//					min = Math.min(min, 1 + M[i + j]);
//					j++;
//				}
//			}
//			M[i] = min;
//		}
//		return M[0];
//	}
	
	public int minJump(int[] array) {
	    // M[i] stores the minimum number of jumps to reach the end of array
	    int[] M = new int[array.length];
	    for (int i = array.length - 2; i >= 0; i--) {
	      int steps = array[i];
	      int minJumps = Integer.MAX_VALUE;
	      M[i] = -1;
	      int j = i;
	      while (j < M.length && j <= i + steps) {
	        if (M[j] > -1) { // can jump to the end
	          minJumps = Math.min(minJumps, M[j]) + 1;
	        }
	        j++;
	      }
	      if (minJumps == Integer.MAX_VALUE) {
	        minJumps = -1;
	      }
	      M[i] = minJumps;
	    }
	    return M[0];
	  }
}
