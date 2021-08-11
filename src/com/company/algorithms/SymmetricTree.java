package com.company.algorithms;

import com.company.base.TreeNode;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recursive(root.left, root.right);
    }

    public boolean recursive(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }

        return left.val == right.val && recursive(left.left, right.right) && recursive(left.right, right.left);
    }
}
