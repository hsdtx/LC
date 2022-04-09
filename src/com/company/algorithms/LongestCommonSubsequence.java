package com.company.algorithms;

public class LongestCommonSubsequence {

    /*
     * 先看到编辑距离那题，再过来刷这道题的（最长公共子序列）
     */

    /**
     * 直接动态规划了
     * dp[i][j]代表text1[0...i]和text2[0...j]字符串之间的最长公共子序列，转移函数如下
     * when i=0, j=0; dp[i][j] = text1[i] == text[j]? 1: 0;
     * when i=0, j!=0; dp[i][j] = text1[i] == text2[j]? 1: dp[i][j-1];
     * when i!=0, j=0; dp[i][j] = text1[i] == text2[j]? 1: dp[i-1][j];
     * when i!=0, j!=0; dp[i][j] = max(dp[i][j-1], dp[i-1][j]);
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0){
            return 0;
        }

        int[][]dp = new int[text1.length()][text2.length()];
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                boolean flag = text1.charAt(i) == text2.charAt(j);
                if (i == 0 && j == 0){
                    dp[i][j] = flag? 1: 0;
                }else if(i == 0){
                    dp[i][j] = flag? 1: dp[i][j-1];
                }else if(j == 0){
                    dp[i][j] = flag? 1: dp[i-1][j];
                }else{
                    dp[i][j] = flag? dp[i-1][j-1] + 1: Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[text1.length()-1][text2.length()-1];
    }
}
