package com.company.algorithms;

import com.company.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PathSum {

    private int temp = 0;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> road = new ArrayList<>();
        recursive(root, road, res, target);

        return res;
    }

    private void recursive(TreeNode root, List<Integer> road, List<List<Integer>> res, int target){
        if (root == null){
            return;
        }

        temp += root.val;
        road.add(root.val);
        if (temp == target && root.left == null && root.right == null){
            res.add(new ArrayList<>(road));
        }

        recursive(root.left, road, res, target);
        recursive(root.right, road, res, target);

        temp -= root.val;
        road.remove(road.size()-1);
    }

}
