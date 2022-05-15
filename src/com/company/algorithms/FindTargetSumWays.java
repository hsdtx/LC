package com.company.algorithms;

import java.util.Arrays;

public class FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n: nums){
            sum += n;
        }

        //其中数字前面加-的数字和为neg
        //则其中加+的数字和为sum-neg
        //则满足target = sum-neg-neg => neg = (sum-target)/2
        //则问题转换为nums中若干数字加合为neg的组合数
        //变成找零钱的问题
        if (sum-target<0 || (sum-target)%2 !=0){
            return 0;
        }

        int neg = (sum-target)/2;
        int len = nums.length;
        int[][] dp = new int[len+1][neg+1];
        dp[0][0] = 1;
        for (int i=0; i<=len; i++){
            for (int j=0; j<=neg; j++){
                if (i >= 1 && j-nums[i-1]>=0){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                } else if (i >= 1 && j-nums[i-1]<0){
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[len][neg];
    }
}
