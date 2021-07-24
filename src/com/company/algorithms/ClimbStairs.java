package com.company.algorithms;

public class ClimbStairs {

    public int dp(int n){
        int[] dp = new int[n+1];
        int[] steps = new int[]{1, 2};
        for (int i = 0; i<=n; i++){
            for (int step: steps){
                if (i > step){
                    dp[i] += dp[i-step];
                }else if(i == step){
                    dp[i] += 1;
                }
            }
        }

        return dp[n];
    }
}
