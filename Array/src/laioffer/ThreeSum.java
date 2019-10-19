package laioffer;
import java.util.*;

public class ThreeSum {
//	public List<List<Integer>> allTriples(int[] array, int target) {
//		List<List<Integer>> result = new ArrayList<>();
//		Arrays.sort(array);
//		for (int i = 0; i < array.length - 2; i++) {
//			// make sure i < j < k such that array[i] + array[j] + array[k] == target
//			// no duplicate i value
//			if (i > 0 && array[i] == array[i - 1]) {
//				continue;
//			}
//			int left = i + 1;
//			int right = array.length - 1;
//			int curTarget = target - array[i];
//			while (left < right) {
//				if (left > i + 1 && array[left] == array[left - 1]) {
//					left++;
//					continue;
//				}
//				if (array[left] + array[right] == curTarget) {
//					result.add(Arrays.asList(array[left], array[right], array[i]));
//					left++;
//					right--;
//				} else if (array[left] + array[right] < curTarget) {
//					left++;
//				} else {
//					right--;
//				}
//			}
//		}
//		return result;
//	}
	
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        if (nums[0] > 0) return result;
        // make sure i < j and no duplicates
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;
                int target = -nums[i];
                while (j < k) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        if (nums[j] + nums[k] == target) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            j++;
                            k--;
                        } else if (nums[j] + nums[k] > target) {
                            k--;
                        } else {
                            j++;
                        }
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
