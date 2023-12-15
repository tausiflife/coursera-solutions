package com.leetcode;



import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepthBinaryTree104 {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return pathLength(root.left, root.right, 1);
    }
    private int pathLength(TreeNode left, TreeNode right, int len) {
        if(left == right)
            return len;
        int leftLen =0, rightLen = 0;
        if(left !=null)
            leftLen = pathLength(left.left, left.right, len + 1);
        if(right !=null)
            rightLen = pathLength(right.left, right.right, len + 1);
        if(leftLen > rightLen)
            return leftLen;
        return rightLen;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
