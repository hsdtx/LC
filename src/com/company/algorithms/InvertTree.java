package com.company.algorithms;

import com.company.base.TreeNode;
import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
