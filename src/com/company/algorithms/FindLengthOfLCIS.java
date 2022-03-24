package com.company.algorithms;

import java.util.Arrays;

public class FindLengthOfLCIS {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }

        int len = nums.length;
        int[] dp = new int[len+1];
        int max = 1;
        for (int i=0; i<=len; i++){
            //i代表长度
            for (int j=0; j<=len-i; j++){
                //j代表起点
                if (i <= 1){
                    dp[j] = i;
                }else if (nums[i+j-1] > nums[i+j-2]){
                    dp[j] = dp[j]+1;
                    max = Math.max(dp[j], max);
                }else{
                    dp[j] = 0;
                }
            }
        }

//        System.out.println(Arrays.toString(dp));
        return max;
    }
}
