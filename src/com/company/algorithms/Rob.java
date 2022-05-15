package com.company.algorithms;

import com.company.base.TreeNode;

import java.util.HashMap;


public class Rob {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        for (int i=0; i<nums.length; i++){
            if (i == 0){
                dp[i+1] = nums[i];
            }else {
                dp[i+1] = Math.max(nums[i]+dp[i-2], dp[i-1]);
            }
        }

        return dp[nums.length];
    }

    private HashMap<TreeNode, Integer> noRoot = new HashMap<>();//不选择根节点偷能偷到的最大值
    private HashMap<TreeNode, Integer> iRoot = new HashMap<>();//选择根节点偷的最大值
    /**
     * 房子呈二叉树形状排布，不能偷相邻的两间房子
     * 求最多能偷多少钱
     */
    public int v1(TreeNode root){
        dfs(root);
        return Math.max(noRoot.getOrDefault(root, 0), iRoot.getOrDefault(root, 0));
    }

    public void dfs(TreeNode root){
        if (root == null){
            return ;
        }

        dfs(root.left);
        dfs(root.right); //子节点先偷

        iRoot.put(root, root.val + noRoot.getOrDefault(root.left, 0) + noRoot.getOrDefault(root.right, 0));
        noRoot.put(root, Math.max(noRoot.getOrDefault(root.left, 0), iRoot.getOrDefault(root.left, 0)) + Math.max(noRoot.getOrDefault(root.right, 0), iRoot.getOrDefault(root.right, 0)));
    }
}
