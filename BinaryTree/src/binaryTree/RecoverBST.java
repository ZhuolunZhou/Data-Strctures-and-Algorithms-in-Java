package binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecoverBST {
	public void recoverTree(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values); 
        Collections.sort(values);
        helper(root, values, 0);
    }
    
    private void helper(TreeNode root, List<Integer> list, int pointer) {
        if (root == null) return;
        helper(root.left, list, pointer);
        System.out.println(pointer);
        System.out.println("old val is " + root.val);
        System.out.println("new val is " + list.get(pointer));
        root.val = list.get(pointer);;
        helper(root.right, list, pointer + 1);
    }
    
    private void inorder(TreeNode root, List<Integer> values) {
        if (root == null) return;
        inorder(root.left, values);
        values.add(root.val);
        inorder(root.right, values);
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
