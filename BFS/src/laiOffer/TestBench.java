package laiOffer;
import java.util.*;
public class TestBench {

	public static void main(String[] args) {
		//		TreeNode root = new TreeNode(1);
		//		root.left = new TreeNode(2);
		//		root.right = new TreeNode(3);
		//		root.right.left = new TreeNode(4);
		//		root.right.right = new TreeNode(5);
		//		
		//		CheckCompleteTree sol = new CheckCompleteTree();
		//		System.out.println(sol.isCompleted(root));

		//		int[][] matrix = new int[][] {{1,3,5,7},{2,4,8,9},{3,5,11,15},{6,8,13,18}};
		//		KthSmallestMatrix sol = new KthSmallestMatrix();
		//		System.out.println(sol.kthSmallest(matrix, 8));
//		KthSum ks = new KthSum();
//		int[] A = new int[] {1,3,5,8,9};
//		int[] B = new int[] {2,3,4,7};
//		System.out.println(ks.kthSum(A, B, 20));
//		KthSum.Entry a = new KthSum.Entry(1,1,10); 
//		KthSum.Entry b = new KthSum.Entry(1,1,10); 
//		System.out.println(a.equals(b));
//		Set<KthSum.Entry> set = new HashSet<>();
//		set.add(a);
//		set.add(b);
//		PutChairI pc = new PutChairI();
//		char[][] gym = { { 'E', 'O', 'C' },
//
//				  {  'C', 'E',  'C' },
//
//				  {  'C',  'C',  'C' } };
//		int[][] shortestDistance = new int[3][3];
//		pc.test(gym, shortestDistance);
//		for (int i = 0; i < shortestDistance.length; i++) {
//			for (int j = 0; j < shortestDistance[0].length; j++) {
//				System.out.print(shortestDistance[i][j] + " ");
//			}
//			System.out.println();
//		}
//		char[][] gym = {{'C','C','E','O','C'},{'C','C','O','C','E'},{'C','C','E','E','C'},
//				{'C','O','C','E','E'},{'C','C','O','C','C'}};
//		List<Integer> result = pc.putChair(gym);
//		for (int i : result) {
//			System.out.print(i + " ");
//		}
		WordLadderII wl = new WordLadderII();
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("log");
		wordList.add("lot");
		wordList.add("cog");
		System.out.println(wl.findLadders("hit", "cog", wordList));
		
//		CourseSchedule cs = new CourseSchedule();
//		System.out.println(cs.canFinish(2, new int[][] {{0,1}}));
//		CourseScheduleII cs = new CourseScheduleII();
//		cs.findOrder(2, new int[][] {{0,1}});
//		CutoffTrees ct = new CutoffTrees();
//		
//		Integer[][] array = {{54581641,64080174,24346381,69107959},{86374198,61363882,68783324,79706116},{668150,92178815,89819108,94701471},{83920491,22724204,46281641,47531096},{89078499,18904913,25462145,60813308}};
//		List<List<Integer>> forest = new ArrayList<>();
//		for (Integer[] i : array) {
//			forest.add(Arrays.asList(i));
//		}
//		System.out.println(ct.cutOffTree(forest));
	}
}
