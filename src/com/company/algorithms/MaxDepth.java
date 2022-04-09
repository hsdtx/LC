package com.company.algorithms;


import com.company.base.TreeNode;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null){
            return 1;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
