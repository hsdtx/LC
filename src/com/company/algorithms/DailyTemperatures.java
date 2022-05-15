package com.company.algorithms;

import java.util.LinkedList;
import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures){
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i=0; i<len; i++){
            for (int j=i+1; j<len; j++){
                if (temperatures[j] > temperatures[i] && res[i] == 0){
                    res[i] = j-i;
                }
            }
        }

        return res;
    }

    /**
     * 单调栈
     */
    public int[] v1(int[] temperatures){
        LinkedList<Integer> stack = new LinkedList<>();
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i=0; i<len; i++){
            while (!stack.isEmpty() && temperatures[stack.getFirst()] < temperatures[i]){
                int index = stack.pop();
                res[index] = i-index;
            }

            stack.addFirst(i);
        }

        return res;
    }
}