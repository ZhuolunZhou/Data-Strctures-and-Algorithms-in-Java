package binaryTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {

	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        serializeHelper(root, sb);
        return sb.append("]").toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (sb.length() != 1) {
            sb.append(",");
        }
        if (root == null) {
            sb.append("null");
            return;
        } else {
            sb.append(root.val);
        }
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
    	int[] index = {0};
        String[] arr = data.substring(1, data.length() - 1).split(",");
        return deserializeHelper(arr, index, arr.length);
    }
    
    private TreeNode deserializeHelper(String[] arr, int[] index, int len) {
        if (index[0] >= len) return null; 
        if (arr[index[0]].equals("null")) {
        	index[0]++;
        	return null;
        }
        int val = getVal(arr[index[0]]);
        TreeNode root = new TreeNode(val);
        index[0]++;
        TreeNode left = deserializeHelper(arr, index, len);
        TreeNode right = deserializeHelper(arr, index, len);
        root.left = left;
        root.right = right;
        return root;
    }
    
    private int getVal(String s) {
        int tmp = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-') {
                sign = -1;
                continue;
            }
            tmp = tmp * 10 + c - '0';
        }
        return sign * tmp;
    }
}
