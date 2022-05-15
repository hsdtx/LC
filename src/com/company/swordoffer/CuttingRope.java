package com.company.swordoffer;

import sun.lwawt.macosx.CSystemTray;

import java.util.Arrays;

public class CuttingRope {

    /**
     * 完全背包之变形
     * 完全背包是加法，这里是乘法
     */
    public int v1(int n){
        long[] dp = new long[n+1];
        dp[0] = 1; //乘法，给个1
        for (int i=1; i<n; i++){
            for (int j=1; j<=n; j++){
                if (j-i >= 0){
                    dp[j] = Math.max(dp[j-i] * i, dp[j]);
                }
            }
        }

        return (int)(dp[n]%1000000007);
    }
}
