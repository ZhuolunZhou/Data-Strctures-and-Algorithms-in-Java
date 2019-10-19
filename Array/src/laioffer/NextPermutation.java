package laioffer;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1) return;
		int right = nums.length - 1;
		while (right - 1 >= 0 && nums[right] <= nums[right - 1]) {
			right--;
		}
		if (right == 0) {
			reverse(nums, 0, nums.length - 1);
		} else {
			int target = nums[right - 1];
			int idx = findSmallestLarger(nums, right, nums.length - 1, target);
			swap(nums, idx, right - 1);
			reverse(nums, right, nums.length - 1);
		}
	}

	private int findSmallestLarger(int[] nums, int left, int right, int target) {
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] <= target) {
				right = mid;
			} else {
				left = mid;
			}
		}
		if (nums[right] > target) {
			return right;
		} else if (nums[left] > target) {
			return left;
		}
		return -1;
	}

	private void reverse(int[] array, int left, int right) {
		while (left < right) {
			int tmp = array[left];
			array[left++] = array[right];
			array[right--] = tmp;
		}
	}

	private void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
}
