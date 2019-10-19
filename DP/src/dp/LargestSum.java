package dp;
import java.util.*;

public class LargestSum {
	// result will be [leftBound, rightBound, largestSum]
	public List<Integer> largestSum(int[] array) {
		if (array == null || array.length == 0) {
			return null; 
		}
		List<Integer> result = new ArrayList<>();
		int curSum = array[0];
		int globalMax = array[0];
		int curLeft = 0;
		int globalLeft = 0;
		int globalRight = 0;
		for (int i = 1; i < array.length; i++) {
			if (curSum < 0) { // adding current value will definitely become smaller
				curSum = array[i]; //东山再起
				curLeft = i;
			} else {
				curSum += array[i];
			}
			if (globalMax < curSum) { // update boundary and largest sum
				globalLeft = curLeft;
				globalRight = i;
				globalMax = curSum;
			}
		}
		result.add(globalLeft);
		result.add(globalRight);
		result.add(globalMax);
		return result;
	}
}
