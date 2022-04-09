package com.company.algorithms;

import com.company.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Flatten {

    private List<TreeNode> list;

    public void flatten(TreeNode root) {
        list = new ArrayList<>();
        recursive(root);
        TreeNode p = new TreeNode(0);
        TreeNode index = p;
        for (int i=0; i<list.size(); i++){
            index.right = list.get(i);
            index.left = null;
            index = index.right;
        }
    }

    private void recursive(TreeNode root){
        if (root == null) return;
        list.add(root);
        recursive(root.left);
        recursive(root.right);
    }

}
