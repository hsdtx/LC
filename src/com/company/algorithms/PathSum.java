package com.company.algorithms;

import com.company.base.TreeNode;

import java.util.HashMap;

public class PathSum {

    public int pathSum(TreeNode root, int targetSum){
        if (root == null){
            return 0;
        }

        int res = rootSum(root, targetSum);
        //下面的代码是尝试把所有节点都当作根节点看一下是否有和为target的路径
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);

        return res;
    }

    /**
     * 从root节点向下看，和为targetSum的路径数
     */
    private int rootSum(TreeNode root, int targetSum){
        if (root == null){
            return 0;
        }

        int res = 0;
        if (root.val == targetSum){
            res++;
        }

        //看下继续往下延伸，能否有更长的路径
        res += rootSum(root.left, targetSum - root.val);
        res += rootSum(root.right, targetSum - root.val);

        return res;
    }

    /**
     * 前缀和
     */
    public int v2(TreeNode root, int targetSum){
        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    private int dfs(TreeNode root, HashMap<Long, Integer> prefix, long curr, int target){
        if (root == null){
            return 0;
        }

        int res = 0;
        curr += root.val;
        long temp = curr-target;
        res += prefix.getOrDefault(temp, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0)+1);
        res += dfs(root.left, prefix, curr, target);
        res += dfs(root.right, prefix, curr, target);
        prefix.put(curr, prefix.get(curr)-1); //回溯
        return res;
    }
}
