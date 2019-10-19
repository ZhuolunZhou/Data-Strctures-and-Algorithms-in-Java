package laioffer;
import java.util.*;

public class TestBench {

	public static void main(String[] args) {
//		LargestSecondLargest ls = new LargestSecondLargest();
//		int[] array = {5,4,2,1,3,6};
//		int[] result = ls.largestAndSecond(array);
//		for (int i : result) {
//			System.out.println(i);
//		}
//		TwoSumPair1 tp = new TwoSumPair1();
//		int[] array = {1,2,2,4};
//		List<List<Integer>> result = tp.allPairs(array, 6);
//		for (List<Integer> ls : result) {
//			for (int i : ls) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//		}
//		ThreeSum ts = new ThreeSum();
//		int[] array = new int[] {1, 1, 2, 2, 3, 2, 4, 5};
//		List<List<Integer>> result = ts.allTriples(array, 8);
//		for (List<Integer> list : result) {
//			System.out.println(list);
//		}
//		MaxWaterTrappedI mt = new MaxWaterTrappedI();
//		System.out.println(mt.maxTrapped(new int[] {3,2,1}));
		
//		ThreeSum ts = new ThreeSum();
//		int[] array = new int[] {1,-1,-1, 0};
//		List<List<Integer>> result = ts.threeSum(array);
//		for (List<Integer> list : result) {
//			System.out.println(list);
//		}
//		NextPermutation np = new NextPermutation();
//		np.nextPermutation(new int[] {1,3,2});
//		Search s = new Search();
//		System.out.println(s.search(new int[] {1,3}, 1));
//		ValidSudoku vs = new ValidSudoku();
//		char[][] board = new char[][] {{'.','.','4','.','.','.','6','3','.'},
//									   {'.','.','.','.','.','.','.','.','.'},
//									   {'5','.','.','.','.','.','.','9','.'},
//									   {'.','.','.','5','6','.','.','.','.'},
//									   {'4','.','3','.','.','.','.','.','1'},
//									   {'.','.','.','7','.','.','.','.','.'},
//									   {'.','.','.','5','.','.','.','.','.'},
//									   {'.','.','.','.','.','.','.','.','.'},
//									   {'.','.','.','.','.','.','.','.','.'}};
//		System.out.println(vs.isValidSudoku(board));
//		FirstMissingPositive fp = new FirstMissingPositive();
//		System.out.println(fp.firstMissingPositive(new int[] {3,4,-1,1}));
//		TotalFruits tf = new TotalFruits();
//		int[] tree = {3,3,3,1,2,1,1,2,3,3,4};
//		System.out.println(tf.totalFruit(tree));
//		MultiplyString ms = new MultiplyString();
//		System.out.println(ms.multiply("498828660196", "840477629533"));
		GetCountArray gc = new GetCountArray();
		int[] result = gc.countArray(new int[] {5,2,6,1});
		for (int i : result) System.out.println(i);
	}

}
