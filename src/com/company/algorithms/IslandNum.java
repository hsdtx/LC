package com.company.algorithms;

public class IslandNum {

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j] == '1' && recursive(grid, i, j)){
                    res ++;
                }
            }
        }

        return res;
    }

    private boolean recursive(char[][] grid, int i, int j){
        if (grid[i][j] == '1'){
            grid[i][j] = '0'; //occupied
            if (i >= 1){
                recursive(grid, i-1, j);
            }

            if (i < grid.length - 1){
                recursive(grid, i+1, j);
            }

            if (j >= 1){
                recursive(grid, i, j-1);
            }

            if (j < grid[0].length - 1){
                recursive(grid, i, j+1);
            }

            return true;
        }

        return false;
    }
}