package com.company.algorithms;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int res = nums[0];

        for (int i=1; i<nums.length; i++){
            res ^= nums[i];
        }

        return res;
    }
}
