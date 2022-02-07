package com.company.algorithms;

import com.company.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.add(root);
                root = root.left;
            }

            if (!stack.isEmpty()){
                root = stack.removeLast();
                res.add(root.val);
                root = root.right;
            }
        }

        return res;
    }
}
