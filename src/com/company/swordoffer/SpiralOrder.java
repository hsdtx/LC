package com.company.swordoffer;

import com.company.algorithms.SubarraySum;

import java.util.Arrays;
import java.util.Stack;

public class SpiralOrder {

    /**
     * 思路没啥问题，代码写的有点垃圾，可以优化下
     */
    public int[] v1(int[][] matrix){
        if (matrix.length == 0){
            return new int[0];
        }

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});

        int[] res= new int[matrix.length * matrix[0].length];
        int index=0;
        int[] direct = new int[]{0, 1}; //最开始向右
        int upLimit = 0;
        int downLimit = matrix.length-1;
        int rightLimit = matrix[0].length-1;
        int leftLimit = 0;
        while (!stack.isEmpty()){
            int[] node = stack.pop();

            res[index++] = matrix[node[0]][node[1]];
            if (direct[0] == 0 && direct[1] == 1 && node[1] == rightLimit){
                upLimit++;
                direct = new int[]{1, 0}; //向下
            }

            if (direct[0] == 1 && direct[1] == 0 && node[0] == downLimit){
                rightLimit--;
                direct = new int[]{0, -1}; //向左
            }

            if (direct[0] == 0 && direct[1] == -1 && node[1] == leftLimit){
                downLimit--;
                direct = new int[]{-1, 0}; //向上
            }

            if (direct[0] == -1 && direct[1] == 0 && node[0] == upLimit){
                leftLimit++;
                direct = new int[]{0, 1}; //向右
            }

            int[] nextNode = new int[]{node[0] + direct[0], node[1] + direct[1]};
//            System.out.println(Arrays.toString(node));
//            System.out.println(Arrays.toString(nextNode));
//            System.out.println(upLimit);
            if (nextNode[0] <= downLimit && nextNode[0] >= upLimit && nextNode[1] >= leftLimit && nextNode[1] <= rightLimit){
                stack.push(nextNode);
            }
        }

        return res;
    }
}