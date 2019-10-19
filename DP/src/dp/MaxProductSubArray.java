package dp;

public class MaxProductSubArray {
	public int maxProduct(int[] nums) {
		int max = nums[0];
        int prevMax = nums[0]; // max product of subarray ending at i - 1 inclusively
        int prevMin = nums[0]; // min product of subarray ending at i - 1 inclusively
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = prevMax;
                prevMax = prevMin;
                prevMin = tmp;
            }
            prevMax = Math.max(prevMax * nums[i], nums[i]);
            prevMin = Math.min(prevMin * nums[i], nums[i]);
            max = Math.max(max, prevMax);
        }
        return max;
	}
}
