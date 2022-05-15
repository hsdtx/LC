package com.company.swordoffer;

public class MaxSubArray {

    public int maxSubArray(int[] nums){
        int max = nums[0];
        int temp = 0;
        for (int i=0; i<nums.length; i++){
            if (temp < 0){
                temp = nums[i];
            }else{
                temp += nums[i];
            }
            max = Math.max(temp, max);
        }

        return max;
    }
}