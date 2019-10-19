package dp;

public class SplitArrayLargestSum {
//	public int splitArray(int[] nums, int m) {
//		if (nums == null || nums.length == 0) return 0;
//		int[] prefixSum = getPrefix(nums);
//		return minSum(prefixSum, m - 1, nums.length - 1);
//	}
//	public int splitArray(int[] nums, int m) {
//		if (nums == null || nums.length == 0) return 0;
//		int[] prefixSum = getPrefix(nums);
//		// M[i][j] represents the min largest sum of subarray [0, j] where cuts i times
//		int[][] M = new int[m][nums.length];
//		for (int i = 0; i < m; i++) {
//			for (int j = i; j < nums.length; j++) {
//				if (i == 0) {
//					M[i][j] = prefixSum[j];
//					continue;
//				}
//				int min = Integer.MAX_VALUE;
//				for (int k = 0; k < j; k++) {
//					int curSum = prefixSum[j] - prefixSum[k];
//					int curMax = Math.max(curSum, M[i - 1][k]);
//					min = Math.min(min, curMax);
//				}
//				M[i][j] = min;
//			}
//		}
//		return M[m - 1][nums.length - 1];
//	}
//		
//	
//	private int[] getPrefix(int[] nums) {
//		int[] prefixSum = new int[nums.length];
//		prefixSum[0] = nums[0];
//		for (int i = 1; i < nums.length; i++) {
//			prefixSum[i] = prefixSum[i - 1] + nums[i];
//		}
//		return prefixSum;
//	}
//	
//	// return the min largest sum of subarray
//	private int minSum(int[] prefixSum, int cutLeft, int cutIdx) {
//		// base case
//		if (cutLeft == 0) {
//			return prefixSum[cutIdx];
//		}
//		int min = Integer.MAX_VALUE;
//		for (int i = cutIdx; i >= 1; i--) {
//			int curSum = prefixSum[cutIdx] - prefixSum[i - 1];
//			int curMax = Math.max(curSum, minSum(prefixSum, cutLeft - 1, i - 1));
//			min = Math.min(min,  curMax);
//		}
//		return min;
//	}
	
	public int splitArray(int[] nums, int m) {
        if(nums.length == 0){
            return 0;
        }
        
        int start = 0, end = 0;
        for(int i = 0; i < nums.length; i++){
            start = Math.max(start, nums[i]);
            end += nums[i];
        }
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(possible(nums, mid, m)){
                end = mid;
            }else{
                start = mid;
            }
        }
        
        if(possible(nums, start, m)){
            return start;
        }
        
        return end;
    }
    
    public boolean possible(int[] nums, int target, int m){
        int count = 1;
        int sum = 0;
        for(int i : nums){
            if(sum + i > target){
                sum = 0;
                count++;
            }
            sum += i;
        }
        return count <= m;
    }
}
