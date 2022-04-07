package com.company.algorithms;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0){
            return 0;
        }

        int max = 0;
        int[][] width = new int[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j] == '1'){
                    if (j>=1) {
                        width[i][j] = width[i][j-1] + 1;
                    } else {
                        width[i][j] = 1;
                    }

                    int minWidth = width[i][j];
                    for (int l=i; l>=0; l--){
                        int height = i-l+1;
                        minWidth = Math.min(minWidth, width[l][j]);
                        if (minWidth == 0){
                            break;
                        }
                        max = Math.max(max, height*minWidth);
                    }
                }
            }
        }

        return max;
    }

    public int stack(char[][] matrix){
        if (matrix.length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] heights = new int[n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (matrix[i][j] == '1'){
                    heights[j] += 1;
                }else{
                    heights[j] = 0;
                }
            }

            max = Math.max(max, stackDetail(heights));
        }

        return max;
    }

    public int stackDetail(int[] heights){
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i=0; i<len; i++){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop(); //比当前高度大的都出栈，不是当前高度的边界
            }
            left[i] = stack.isEmpty()? -1: stack.peek(); //-1是虚拟的边界
            stack.push(i);
        }

        if (!stack.isEmpty()){
            stack.clear();
        }

        for (int i=len-1; i>=0; i--){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty()? len: stack.peek();
            stack.push(i);
        }

        int max = 0;
        for (int i=0; i<len; i++){
            max = Math.max(max, (right[i]-left[i]-1)*heights[i]);
        }
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        return max;
    }
}
