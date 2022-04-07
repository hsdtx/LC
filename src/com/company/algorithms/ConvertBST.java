package com.company.algorithms;

import com.company.base.TreeNode;

public class ConvertBST {

    private int sum;

    public TreeNode convertBST(TreeNode root) {
        recursive(root);
        return root;
    }

    private void recursive(TreeNode root){
        if (root == null) return;

        recursive(root.right);
        sum += root.val;
        root.val = sum;
        recursive(root.left);
    }
}
