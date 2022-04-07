package com.company.algorithms;

public class NumTrees {

    public int numTrees(int n){

        int[] dp = new int[n+1];
        dp[0] = 1; //虚拟的，也可以理解成空树是一种情况

        //i代表以n为根
        //小于等于i-1的数可以放在树的左边，设个数为m
        //大于等于i+1的数可以放在右边，设个数为n，则组合后个数为m*n
        //为i-1个数的搜索二叉树个数就为dp[i-1]，i+1到n的数组成的搜索二叉树为dp[n-i]
        for (int j=1; j<=n; j++){
            for (int i=1; i<=j; i++){
                dp[j] += dp[i-1] * dp[j-i];
            }
        }

        return dp[n];
    }
}
