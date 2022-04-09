package com.company.algorithms;

import java.util.LinkedList;

public class MinPathSum {
    private int minSum = Integer.MAX_VALUE;
    private int tempSum = 0;

    public int minPathSum(int[][] grid) {
        recursive(0, 0, grid);
        return minSum;
    }

    public void recursive(int i, int j, int[][] grid){
        tempSum += grid[i][j];
        if (i == grid.length-1 && j == grid[0].length-1){
            minSum = Math.min(minSum, tempSum);
        }

        if (tempSum < minSum){
            if (i < grid.length - 1){
                recursive(i+1, j, grid);
            }

            if (j < grid[0].length - 1){
                recursive(i, j+1, grid);
            }
        }
        tempSum -= grid[i][j];
    }

    public int dp(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                if (i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                    continue;
                }

                if (i == 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                    continue;
                }

                if (j == 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                    continue;
                }

                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }
}
