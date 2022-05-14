package com.company.swordoffer;

public class MaxValue {

    public int v1(int[][] grid){
        int h = grid.length, w = grid[0].length;
        int[][] dp = new int[h][w];
        for (int i=0; i<h; i++){
            for (int j=0; j<w; j++){
                if (i==0 && j==0){
                    dp[i][j] = grid[i][j];
                }else if(i==0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else if(j==0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1] + grid[i][j], dp[i-1][j] + grid[i][j]);
                }
            }
        }

        return dp[h-1][w-1];
    }
}
