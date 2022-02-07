package com.company.algorithms;

import com.company.base.TreeNode;

public class LowestCommonAncestor {
    private TreeNode target;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recursiveFind(root, p, q);
        return target;
    }

    private TreeNode recursiveFind(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return null;

        TreeNode left = recursiveFind(root.left, p, q);
        TreeNode right = recursiveFind(root.right, p, q);
        if ((left == p && right == q)
                || (left == q && right == p)
                || (root == p && (left == q || right == q)
                || (root == q && (left == p || right == p)))){
            target = root;
            return null;
        }
        if (root == p || left == p || right == p){
            return p;
        }else if(root == q || left == q || right == q){
            return q;
        }

        return null;
    }
}
