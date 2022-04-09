package com.company.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLengthOfLIS {

    public int findLengthOfLIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int res = 1;
        for (int i=0; i<n; i++){
            dp[i] = 1;
            for (int j=0; j<i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                    res = Math.max(dp[i], res);
                }
            }
        }

        return res;
    }

    public int findNumberOfLIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n]; //搞个数组计数
        int ans = 0;
        int maxLength = 1; //初始情况最长为1
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        for (int i=0; i<n; i++){
            for (int j=0; j<i; j++){
                if (nums[i] > nums[j]){
                    if (dp[j]+1 > dp[i]){
                        //找到更长的子序列，需要更新dp[i]和cnt[i]
                        cnt[i] = cnt[j];
                        dp[i] = dp[j]+1;
                    }else if(dp[j]+1 == dp[i]){
                        //找到和最长子序列一样长的子序列，仅更新cnt[i]
                        cnt[i] += cnt[j];
                    }
                }
            }

            if (dp[i] > maxLength){
                maxLength = dp[i];
                ans = cnt[i];
            }else if(dp[i] == maxLength){
                ans += cnt[i];
            }
        }

        return ans;
    }
}