package com.company.algorithms;

import sun.nio.cs.ext.MacHebrew;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i=1; i<=amount; i++){
            for (int j=0; j<coins.length; j++){
                if (i-coins[j]>=0 && dp[i-coins[j]] != -1){
                    int rep = dp[i-coins[j]]+1;
                    dp[i] = dp[i] == -1? rep: Math.min(dp[i], rep);
                }
            }
        }

        return dp[amount];
    }
}
