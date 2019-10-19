package recursion;
import java.util.*;

public class TestBench {

	public static void main(String[] args) {
//		IsMatch im = new IsMatch();
//		String s = "mississippi";
//		String p = "mis*is*p*.";
//		System.out.println(im.isMatch(s, p));
//		SpiralTraverseII s = new SpiralTraverseII();
//		int[][] matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//		s.spiralOrder(matrix);
		StrobogrammaticNumII sg = new StrobogrammaticNumII();
		sg.findStrobogrammatic(2);
	}

	

	public static void printMatrix(int[][] matrix) {
		for (int[] arr : matrix) {
			for (int i : arr ) { 
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
