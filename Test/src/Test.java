import java.util.*;
public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		int[] array = new int[] {1,5};
		//		int[] res = kClosest(array,2,2);
		//		int num = (int)(Math.random() * 5);
		//		System.out.println(num);
		//		char[] array = new char[] {'s','t','u','d','e','n','t'};
		//		String s = new String(array, 1, 5);
		//		System.out.println(s);
		//		List<Integer> list = new ArrayList<>();
		//		list.add(1);
		//		list.add(2);
		//		list.add(3);
		//		for (Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
		//			Integer i = iter.next();
		//			System.out.println(i);
		//		}
		//		List<Integer> lengths = new ArrayList<>();
		//		for (int i = 1; i <= 8; i++) {
		//			lengths.add(i);
		//		}
		//		int[] buckets = new int[10];
		//	    for (Integer len : lengths) {
		//	      buckets[len]++;
		//	    }
		//	    int sum = 0;
		//	    int i = 10;
		//	    while (sum <= 0.05 * lengths.size()) {
		//	      sum += buckets[--i];
		//	    }
		//	    System.out.println(i);
		//		StringBuilder sb = new StringBuilder();
		//		sb.append('a');
		//		sb.append("cdb");
		//		System.out.println(sb);
		//		int[] array = {1};
//		System.out.println(hex(4096));
//		char[] arr = new char[] {'0', '1', '0'};
//		System.out.println(convertToInt(arr, 0, 1));
//		int[][] matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//		for (int j = 0; j < 4; j++) {
//			int i = 0;
//			int k = j;
//			while (i < 4 && k < 4) {
//				System.out.println(matrix[i][k]);
//				i++;
//				k++;
//			}
//		}
		int[] array = new int[] {1,2,3,4,5};
		System.out.println(array[findLargestSmaller(array, 4, 0, array.length - 1)]);
		
	}
	
	
	public static int findLargestSmaller(int[] array, int target, int left, int right) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] >= target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}
	
	public static int[] kClosest(int[] array, int target, int k) {
		// Write your solution here
		int left = 0;
		int right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] <= target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			if (left < 0) {
				result[i] = array[right];
			} else if (right > array.length - 1) {
				result[i] = array[left];
			} else if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
				result[i] = array[left];
				left--;
			} else {
				result[i] = array[right];
				right++;
			}		
		}
		return result;
	}

	public static String hex(int number) {
		StringBuilder sb = new StringBuilder();
		sb.append("0x");
		if (number == 0) {
			return sb.append('0').toString();
		}
		char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		for (int i = 28; i >= 0; i -= 4) {
			char digit = digits[(number >> i) & 0b1111];
			if (digit != '0' || sb.length() > 2) {
				sb.append(digit);
			}

		}
		return sb.toString();
	}
	
	private static Integer convertToInt(char[] array, int left, int right) {
		Integer num = 0;
		boolean hasZero = false;
		for (int i = left; i <= right; i++) {
			if (array[left] == '0') {
				hasZero = true;
			} else if (hasZero) {
				return null;
			}
			num = num * 10 + (array[i] - '0');
		}
		return num;
	}
}
