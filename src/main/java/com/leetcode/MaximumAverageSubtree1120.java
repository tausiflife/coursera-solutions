package com.leetcode;

public class MaximumAverageSubtree1120 {
    private Double average = 0d;

    public static void main(String[] args) {
        MaximumAverageSubtree1120 tree = new MaximumAverageSubtree1120();
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(3);
        root.left = left;
        left = new TreeNode(2);
        TreeNode right = new TreeNode(1);
        root.left.left = left;
        root.left.right = right;
        System.out.println(tree.maximumAverageSubtree(root));
    }
    public double maximumAverageSubtree(TreeNode root) {
        sumOfSubTree(root, 0d);
        return average;
    }

    private int sumOfSubTree(TreeNode node, Double avg) {
        if(node == null)
            return 0;
        int sum = node.val;
        int count = 1;
        int leftSum = 0, rightSum = 0;
        if(node.left != null) {
            leftSum = sumOfSubTree(node.left, avg);
            count++;
        }
        if(node.right != null) {
            rightSum = sumOfSubTree(node.right, avg);
            count++;
        }
        double nodeAvg = Double.valueOf(sum + leftSum + rightSum) / count;
        average = Math.max(nodeAvg, average);
        return (sum + leftSum + rightSum);
    }
}
