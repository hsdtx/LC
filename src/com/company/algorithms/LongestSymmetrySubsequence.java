package com.company.algorithms;

public class LongestSymmetrySubsequence {
    public String dp(String s){
        char[] sequence = s.toCharArray();
        int longest = 1;
        int resBegin = 0;
        int resEnd = 0;

        boolean[][] dp = new boolean[sequence.length][sequence.length]; //默认为true
        for (int i = 0; i < sequence.length; i++){
            for (int j = i; j >= 0; j--){
                if (i == j){
                    dp[i][j] = true;
                } else if (sequence[i] == sequence[j] && (i-j+1 <= 2 || dp[i-1][j+1])){
                    dp[i][j] = true;
                    if (longest < i-j+1){
                        longest = i-j+1;
                        resBegin = j;
                        resEnd = i;
                    }
                }

            }
        }

        return s.substring(resBegin, resEnd + 1);
    }

    /**
     * 暴力解法
     * @return
     */
    public String brute(String s){
        char[] sequence = s.toCharArray();
        int longest = 0;
        int resBegin = 0;
        int resEnd = 0;
        for (int i = 0; i < sequence.length; i++){
            for (int j = i; j < sequence.length; j++){
                if (checkSymmetrySequence(sequence, i, j-i+1)){
                    if (j-i+1 > longest){
                        longest = j-i+1;
                        resBegin = i;
                        resEnd = j;
                    }
                }
            }
        }

        return s.substring(resBegin, resEnd+1);
    }

    private boolean checkSymmetrySequence(char[] sequence, int begin, int length){
        int end = begin + length - 1;
        while (begin < end){
            if (sequence[begin] != sequence[end]){
                return false;
            }else{
                begin ++;
                end --;
            }
        }

        return true;
    }
}
