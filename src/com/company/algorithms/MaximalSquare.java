package com.company.algorithms;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length]; //dp矩阵记录从[0, 0]到[i, j]的最大正方形的边长

        int line = 0;
        for (int i=0; i<dp.length; i++){
            for (int j=0; j < dp[0].length; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = matrix[i][j] == '1'? 1: 0;
                }else{
                    if (matrix[i][j] == '1'){
                        int min = Math.min(dp[i-1][j-1], dp[i-1][j]);
                        min = Math.min(dp[i][j-1], min);
                        dp[i][j] = min + 1;
                    }else{
                        dp[i][j] = 0;
                    }
                }

                line = Math.max(line, dp[i][j]);
            }
        }

        return line*line;
    }
}
