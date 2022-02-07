package com.company.algorithms;

import com.company.base.TreeNode;

public class DiameterOfBinaryTree {
    private int max;

    /*
     * dfs
     */
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        recursive(root);
        return --max;
    }

    /**
     * 返回节点的最大深度
     * @param root
     * @return
     */
    private int recursive(TreeNode root){
        if (root == null){
            return 0;
        }else if(root.left == null && root.right == null){
            max = Math.max(1, max);
            return 1;
        }

        int left = recursive(root.left);
        int right = recursive(root.right);
        max = Math.max(left + right + 1, max);
        return Math.max(left, right) + 1;
    }
}
