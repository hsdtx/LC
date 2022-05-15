package com.company.algorithms;

import java.util.Arrays;

public class CanPartition {

    public boolean canPartition(int[] nums){
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i<len; i++){
            sum += nums[i];
        }

        if (sum%2 != 0){
            return false;
        }
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int i=0; i<len; i++){
            for (int j=target; j-nums[i]>=0; j--){
                dp[j] |= dp[j-nums[i]];
            }
        }

        return dp[target];
    }
}
