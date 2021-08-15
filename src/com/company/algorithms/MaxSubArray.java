package com.company.algorithms;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        for (int i=0; i<dp.length; i++){
            if (i == 0){
                dp[i] = nums[0];
            }else{
                dp[i] = Math.max(dp[i-1] + nums[i], nums[i]); //另起一段还是延续上一段？
                max = Math.max(dp[i], max);
            }
        }

        return max;
    }
}
