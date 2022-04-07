package com.company.algorithms;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleArea {

    /*
     * 暴力解法，时间复杂度为O(n2)
     */
    public int bruce(int[] heights) {
        int max = 0;
        for (int i=0; i<heights.length; i++){
            int leftLimit = i;
            int rightLimit = i;

            //向左和向右寻找能延申到最远的坐标
            for (int j=i; j<heights.length; j++){
               if (heights[j]>=heights[i]){
                   rightLimit = j;
               }else{
                   break;
               }
            }

            for (int j=i; j>=0; j--){
                if (heights[j]>=heights[i]){
                    leftLimit = j;
                }else{
                    break;
                }
            }

            max = Math.max(max, (rightLimit-leftLimit+1)*heights[i]);
        }

        return max;
    }

    public int stack(int[] heights){
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
