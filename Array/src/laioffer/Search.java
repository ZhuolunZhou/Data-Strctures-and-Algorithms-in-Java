package laioffer;

public class Search {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return -1;
		// find the pivot
		int index = findPivot(nums);
		// find target
		if (index == -1) {
			return binarySearch(nums, target, 0, nums.length - 1);
		} else if (target > nums[0]) {
			return binarySearch(nums, target, 0, index - 1);
		} else {
			return binarySearch(nums, target, index, nums.length - 1);
		}
	}

	private int binarySearch(int[] nums, int target, int left, int right) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}         
		}
		return -1;
	}

	private int findPivot(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] >= nums[0]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		if (nums[left] < nums[0]) {
            return left;
        } else if (nums[right] < nums[0]) {
            return right;
        }
        return -1;
	}
}
