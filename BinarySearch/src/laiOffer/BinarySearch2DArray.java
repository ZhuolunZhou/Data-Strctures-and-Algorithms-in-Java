package laiOffer;

public class BinarySearch2DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int[] idx = binarySearch2DArray(matrix, 10);
		for (int i: idx) {
			System.out.print(i + " ");
		}

	}
	
	// Time complexity: O(log(m*n))
	// Space complexity: O(1)
	public static int[] binarySearch2DArray(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new int[] {-1,-1};
		}
		int nRow = matrix.length;
		int nCol = matrix[0].length;
		int left = 0;
		int right = nRow * nCol - 1;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int row = mid / nCol;
			int col = mid % nCol;
			if (matrix[row][col] == target) {
				return new int[] {row, col};
			} else if (matrix[row][col] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return new int[] {-1,-1};
	}

}
