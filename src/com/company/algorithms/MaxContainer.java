package com.company.algorithms;

/**
 * 盛最多水的最大容器
 */
public class MaxContainer {

    /**
     * 双指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height.length <= 1){
            return 0;
        }

        int i = 0;
        int j = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (i < j){
            int l = j - i;
            int h = Math.min(height[i], height[j]);
            max = Math.max(h * l, max);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
}
