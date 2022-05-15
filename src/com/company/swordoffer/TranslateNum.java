package com.company.swordoffer;

public class TranslateNum {

    public int v1(int num){
        String numStr = String.valueOf(num);
        int[] dp = new int[numStr.length()+1];
        dp[0] = 1; //初始化

        for (int i=0; i<numStr.length(); i++){
            dp[i+1] = dp[i];
            int lastDigit = i < 1? 0: numStr.charAt(i-1) - '0';
            int twoDigitNum = lastDigit * 10 + numStr.charAt(i) - '0';
            if (twoDigitNum >= 10 && twoDigitNum <= 25){
                dp[i+1] += dp[i-1];
            }
        }

        return dp[numStr.length()];
    }
}
