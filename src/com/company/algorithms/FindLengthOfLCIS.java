package com.company.algorithms;

public class FindLengthOfLCIS {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }

        int max = 1;
        int temp = 0;
        for (int i=0; i<nums.length; i++){
            if (i == 0 || nums[i] > nums[i-1]){
                temp++;
                max = Math.max(max, temp);
            }else{
                temp = 1;
            }
        }

        return max;
    }
}