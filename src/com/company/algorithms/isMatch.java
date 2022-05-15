package com.company.algorithms;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class isMatch {
    
    /**
     * 这个代码是错误的，想通过简单的迭代解决问题，实际上实现不了
     */
    public boolean v1(String s, String p){
        int sLen = s.length();
        int pLen = p.length();

        int i=pLen-1, j=sLen-1;
        while(i>=0){
            if(p.charAt(i) == '*'){
                char mark = p.charAt(i-1); 
                
                while(j>=0 && (s.charAt(j) == mark || mark == '.')){
                    j--;
                }

                i-=2;
            }else if(p.charAt(i) == '.' || (j >=0 && p.charAt(i) == s.charAt(j))){
                i--;
                j--;
            }else{
                break;
            }
        }

        // System.out.println(i + " " + j);

        if(i < 0 && j < 0){
            return true;
        }

        return false;
    }

    /**
     * 动态规划，想到思路了，转移方程写不出来
     */
    public boolean v2(String s, String p){
        int sLen = s.length();
        int pLen = p.length();
     
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        for(int i=0; i<=sLen; i++){
            for(int j=1; j<=pLen; j++){
                if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2];
                    if(v2Match(s, p, i, j-1)){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }else{
                    if(v2Match(s, p, i, j)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }

        for(boolean[] array: dp){
            System.out.println(Arrays.toString(array));
        }

        return dp[sLen][pLen];
    }

    private boolean v2Match(String s, String p, int i, int j){
        if(i == 0){
            //空字符串与非空pattern做对比，衡返回false
            return false;
        }

        if(p.charAt(j-1) == '.'){
            return true;
        }

        return s.charAt(i-1) == p.charAt(j-1);
    }
}