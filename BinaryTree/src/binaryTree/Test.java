package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
//		PathSumTarget pst = new PathSumTarget();
//		TreeNode root = new TreeNode(5);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(11);
//		root.right.left = new TreeNode(6);
//		root.right.right = new TreeNode(14);
//		root.right.left.left = new TreeNode(3);
//		System.out.println(pst.exist(root, 11));
		
//		MaxPathSumI mps = new MaxPathSumI();
//		TreeNode root = new TreeNode(3);
//		root.left = new TreeNode(-8);
//		root.right = new TreeNode(9);
//		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(10);
//		root.right.left = new TreeNode(2);
//		root.right.right = new TreeNode(-5);
//		root.left.left.left = new TreeNode(1);
//		root.left.left.right = new TreeNode(-2);
//		System.out.println(mps.maxPathSum(root));
//		RecoverBST bst = new RecoverBST();
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(3);
//		root.left.right = new TreeNode(2);
//		bst.recoverTree(root);
		Codec c = new Codec();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
//		TreeNode root = new TreeNode(-1);
//		root.left = new TreeNode(0);
//		root.right = new TreeNode(1);
		c.deserialize(c.serialize(root));
//		String data = "[-1, 0, 1]";
//		String[] array = data.substring(1, data.length() - 1).split(",");
//		for (String s : array) System.out.println(s);
	}

	public static int[] findTwoSwapped(List<Integer> nums) {
		  int n = nums.size();
		  int x = -1, y = -1;
		  for(int i = 0; i < n - 1; ++i) {
		    if (nums.get(i + 1) < nums.get(i)) {
		      y = nums.get(i + 1);
		      // first swap occurence
		      if (x == -1) x = nums.get(i);
		      // second swap occurence
		      else break;
		    }
		  }
		  return new int[]{x, y};
		}
	
}
