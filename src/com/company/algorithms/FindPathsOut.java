package com.company.algorithms;

public class FindPathsOut {
    private static final int mod = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][]rem = new int[maxMove+1][m][n];
        for (int i=0; i<maxMove+1; i++){
            for (int j=0; j<m; j++){
                for (int l=0; l<n; l++){
                    rem[i][j][l] = -1; //初始化
                }
            }
        }

        return subFindPaths(m, n, maxMove, startRow, startColumn, rem);
    }

    public int subFindPaths(int m, int n, int maxMove, int startRow, int startColumn, int[][][] rem) {
        if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n){
            return 1; //一条出界的线路
        }

        if (rem[maxMove][startRow][startColumn] != -1){
            return rem[maxMove][startRow][startColumn];
        }

        if (maxMove <= 0){
            return 0; //走完可用的步数了
        }

        //up
        int up = subFindPaths(m, n, maxMove-1, startRow+1, startColumn,rem);
        //down
        int down = subFindPaths(m, n, maxMove-1, startRow-1, startColumn,rem);
        //left
        int left = subFindPaths(m, n, maxMove-1, startRow, startColumn-1,rem);
        //right
        int right = subFindPaths(m, n, maxMove-1, startRow, startColumn+1,rem);

        /*
         * 只能加一次取模一次，避免丢失精度
         */
        int res = (up + down)%mod;
        res = (res+left)%mod;
        res = (res+right)%mod;

        return rem[maxMove][startRow][startColumn] = res;
    }
}