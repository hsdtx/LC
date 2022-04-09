package com.company.algorithms;

import java.util.Arrays;

public class RotateMap {

    /**
     * 感觉没啥技巧，归纳
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i=0; i<(matrix.length+1)/2; i++){
            for (int j=0; j<matrix[0].length; j++){
                int temp = matrix[n-i-1][j];
                matrix[n-i-1][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<=i; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
