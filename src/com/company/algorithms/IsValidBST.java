package com.company.algorithms;

import com.company.base.TreeNode;

public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return recursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean recursive(TreeNode root, long min, long max){
        if (root == null) return true;

        if (root.val >= max || root.val <= min){
            return false;
        }

        return recursive(root.left, min, root.val) && recursive(root.right, root.val, max);
    }
}
