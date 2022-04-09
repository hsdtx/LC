package com.company.algorithms;

import com.company.base.TreeNode;

public class MaxPathSum {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = root.val; //随便取个值
        maxValue(root);

        return maxSum;
    }

    private int maxValue(TreeNode root){
        if (root == null) return 0;

        int leftValue = Math.max(maxValue(root.left), 0); //小于0则不选取
        int rightValue = Math.max(maxValue(root.right), 0);

        int tempMaxSum = root.val + leftValue + rightValue;
        maxSum = Math.max(tempMaxSum, maxSum);

        return root.val + Math.max(leftValue, rightValue); //只选取左右其中一支，保证每个节点只被遍历一次
    }
}
