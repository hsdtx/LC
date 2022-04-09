package com.company.algorithms;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        int maxValue = nums[0];

        for (int i=0; i<nums.length; i++){
            if (i == 0){
                min[i] = nums[i];
                max[i] = nums[i];
                continue;
            }

            int temp0 = min[i-1] * nums[i];
            int temp1 = max[i-1] * nums[i];
            min[i] = Math.min(temp0, Math.min(temp1, nums[i]));
            max[i] = Math.max(temp0, Math.max(temp1, nums[i]));
            maxValue = Math.max(max[i], maxValue);
        }

        return maxValue;
    }
}
