package com.company.algorithms;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int res = nums[0];

        for (int i=1; i<nums.length; i++){
            res ^= nums[i];
        }

        return res;
    }

    /**
     *
     */
    public int v1(int[] nums){
        int n = nums.length;
        for (int i=0; i<n; i++){
            nums[nums[i]-1] += n+1;
        }

        int ans = -1;
        for (int i=0; i<n; i++){
            if (nums[i]/(n-1) == 2){
                ans = i+1;
            }
        }

        return ans;
    }
}
