package com.company.swordoffer;

import java.util.HashMap;

public class MajorElement {

    public int v1(int[] nums){
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int n: nums){
            count.put(n, count.getOrDefault(n, 0)+1);
        }

        for (int n: count.keySet()){
            if (count.get(n) >= (nums.length+1)/2){
                return n;
            }
        }

        return nums[0];
    }

}
