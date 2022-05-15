package com.company.algorithms;

class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k){
        int[] res = new int[nums.length-k+1];
        for(int i=0; i<=nums.length-k; i++){
            int max = nums[i];
            for(int j=i+1; j<i+k; j++){
                max = Math.max(nums[j], max);
            }
            res[i] = max;
        }

        return res;
    }
    
}
