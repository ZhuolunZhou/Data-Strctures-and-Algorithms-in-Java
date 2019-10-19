package recursion;
import java.util.*;

public class SpiralTraverseI {
	public List<Integer> spiral(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		// corner case
		if (matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		helper(matrix, matrix.length, 0, 0, result);
		return result;
	}

	private void helper(int[][] matrix, int size, int row, int col, List<Integer> result) {
		// base case
		if (size <= 1) {
			if (size == 1) {
				result.add(matrix[row][col]);
			}
			return;
		}
		for (int i = 0; i < size - 1; i++) {
			result.add(matrix[row][col + i]);
		}
		for (int i = 0; i < size - 1; i++) {
			result.add(matrix[row + i][col + size - 1]);
		}
		for (int i = 0; i < size - 1; i++) {
			result.add(matrix[row + size - 1][col + size - 1 - i]);
		}
		for (int i = 0; i < size - 1; i++) {
			result.add(matrix[row + size - 1 - i][col]);
		}
		helper(matrix, size - 2, row + 1, col + 1, result);
	}
}
