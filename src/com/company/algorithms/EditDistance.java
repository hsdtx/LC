package com.company.algorithms;

import java.util.Arrays;

public class EditDistance {
    
    public int editDistance(String word1, String word2){
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1]; //the dp array save the minimum edit distance to change word1[1...i] to word2[1...j]

        //initial
        for(int i=0; i<=len1; i++){
            dp[i][0] = i; 
        }
        for(int j=0; j<=len2; j++){
            dp[0][j] = j;
        }

        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    int temp = Math.min(dp[i][j-1]+1, dp[i-1][j]+1);
                    dp[i][j] = Math.min(temp, dp[i-1][j-1]);
                }else{
                    int temp = Math.min(dp[i][j-1]+1, dp[i-1][j]+1);
                    dp[i][j] = Math.min(temp, dp[i-1][j-1]+1);
                }
            }
        }

        for(int[] line: dp){
            System.out.println(Arrays.toString(line));
        }

        return dp[len1][len2];
    }
}
