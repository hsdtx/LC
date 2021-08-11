package com.company.algorithms;

public class JumpGame {

    /**
     * 时间限制超限
     * @param nums
     * @return
     */
    public boolean canJumpBak(int[] nums){
        boolean[][] dp = new boolean[nums.length][nums.length];

        for (int i=nums.length-1; i>=0; i--){
            for (int j=nums.length-1; j>=i; j--){
                if (i == j){
                    dp[i][j] = true;
                }

                if (nums[i] > 0){
                    for (int l=1; l<=nums[i] && l<=j-i; l++){
                        dp[i][j] = dp[i][j] || dp[i+l][j];
                    }
                }
            }
        }

        return dp[0][nums.length-1];
    }

    /**
     * 有些算法题并不适用dp，贪心算法即可
     * 但是很难察觉哪道题是贪心...
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums){
        int rightMost = 0; //可以达到的最远位置的坐标
        for (int i=0; i<nums.length; i++){
            if (i <= rightMost){
                //如果当前遍历到的坐标小于当前可以到达最远坐标
                rightMost = Math.max(rightMost, i+nums[i]); //刷新最远坐标
                if (rightMost >= nums.length -1){
                    return true;
                }
            }else{
                return false;
            }
        }

        return false;
    }
}
