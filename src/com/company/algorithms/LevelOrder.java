package com.company.algorithms;

import com.company.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        recursive(res, root, 0);
        return res;
    }

    private void recursive(List<List<Integer>> res, TreeNode root, int level){
        if (root == null) return;
        System.out.println(level);

        //res List个数不够
        for (int i = res.size(); i <= level; i++){
            res.add(new ArrayList<>());
        }

        res.get(level).add(root.val);
        recursive(res, root.left, level + 1);
        recursive(res, root.right, level + 1);
    }
}
