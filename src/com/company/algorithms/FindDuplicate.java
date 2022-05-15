package com.company.algorithms;

import java.util.HashMap;

public class FindDuplicate {

    /**
     * 通用解法，HashMap
     */
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = nums[0];
        for (int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == 2){
                ans = nums[i];
            }
        }

        return ans;
    }

}
