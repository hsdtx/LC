package com.company.algorithms;

import java.util.Stack;

public class TrapRain {

    /**
     * 单调栈
     * @param height
     * @return
     */
    public int trap(int[] height){
        int res = 0;
        if (height.length == 0){
            return res;
        }

        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < height.length; index ++){
            while (!stack.empty() && height[index] > height[stack.peek()]){
                int top = stack.pop();
                //再判一次栈是否为空，判断是否有左侧的柱子
                if (!stack.empty()){
                    int left = stack.peek();
                    int h = Math.min(height[index], height[left]) - height[top];
                    int l = index - left - 1;
                    res += h * l;
                }
            }
            stack.push(index);
        }

        return res;
    }
}
