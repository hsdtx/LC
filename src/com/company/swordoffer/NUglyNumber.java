package com.company.swordoffer;

import java.util.Arrays;

public class NUglyNumber {

    public int v1(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i=1; i<n; i++){
            int num2 = dp[index2] * 2, num3= dp[index3] * 3, num5 = dp[index5] * 5;
            System.out.println(num2 + " " + num3 + " " + num5);
            dp[i] = Math.min(Math.min(num2, num3), num5);

            if (dp[i] == num2){
                index2++;
            }

            if(dp[i] == num3){
                index3++;
            }

            if (dp[i] == num5){
                index5++;
            }
        }

        return dp[n-1];
    }
}
