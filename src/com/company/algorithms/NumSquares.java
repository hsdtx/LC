package com.company.algorithms;

public class NumSquares {

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i=0; i<=n; i++){
            if (i == 0){
                dp[i] = 0;
                continue;
            }

            int minSquare = n;
            for (int j=1; j*j<=i; j++){
                minSquare = Math.min(minSquare, dp[i-j*j]+1);
            }
            dp[i] = minSquare;
        }

        return dp[n];
    }
}