package recursion;
import java.util.*;

public class SpiralTraverseII {
//	public List<Integer> spiral(int[][] matrix) {
//		List<Integer> result = new ArrayList<>();
//		if (matrix.length == 0 || matrix[0].length == 0) {
//			return result;
//		}
//		int N = matrix.length;
//		int M = matrix[0].length;
//		helper(matrix, N, M, 0, 0, result);
//		return result;
//	}
//
//	private void helper(int[][] matrix, int N, int M, 
//			int row, int col, List<Integer> result) {
//		if (M <= 1 || N <= 1) {
//			if (M == 1 && N == 1) {
//				result.add(matrix[row][col]);
//			} else if (N == 1 && M != 1) {
//				for (int i = 0; i < M; i++) {
//					result.add(matrix[row][col + i]);
//				}
//			} else if (M == 1 && N != 1) {
//				for (int i = 0; i < N; i++) {
//					result.add(matrix[row + i][col]);
//				}
//			} 
//			return;	
//
//		}
//		for (int i = 0; i < M - 1; i++) {
//			result.add(matrix[row][col + i]);
//		}
//		for (int i = 0; i < N - 1; i++) {
//			result.add(matrix[row + i][col + M - 1]);
//		}
//		for (int i = 0; i < M - 1; i++) {
//			result.add(matrix[row + N - 1][col + M - 1 - i]);
//		}
//		for (int i = 0; i < N - 1; i++) {
//			result.add(matrix[row + N - 1 - i][col]);
//		}
//		helper(matrix, N - 2, M - 2, row + 1, col + 1, result);
//	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null) return result;
        int m = matrix.length, n;
        if (m == 0 || (n = matrix[0].length) == 0) return result;
        spiralOrder(matrix, 0, 0, m, n, result);
        return result;
    }
    
    private void spiralOrder(int[][] matrix, int row, int col, int m, int n, List<Integer> result) {
        // base case
        if (m <= 0 || n <= 0) {
            return;
        } else if (m == 1) {
            for (int i = 0; i < n; i++) {
                result.add(matrix[row][col + i]);
            } 
            return;
        } else if (n == 1) {
            for (int i = 0; i < m; i++) {
                result.add(matrix[row + i][col]);   
            }
            return;
        }
        
        for (int i = 0; i < n - 1; i++) {
            result.add(matrix[row][col + i]);
        }
        for (int i = 0; i < m - 1; i++) {
            result.add(matrix[row + i][col + n - 1]);
        }
        for (int i = 0; i < n - 1; i++) {
            result.add(matrix[row + m - 1][col + n - 1 - i]);
        }
        for (int i = 0; i < m - 1; i++) {
            result.add(matrix[row + m - 1 - i][col]);
        }
        spiralOrder(matrix, row + 1, col + 1, m - 2, n - 2, result);
    }
}
