package com.company.algorithms;

import java.util.HashMap;

/*
 * 和为K的子数组个数
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        int res = 0;

        for (int i=0; i<nums.length; i++){
            for (int l=1; l<=nums.length; l++){
                if (i+l-1 < nums.length){
                    dp[i] += nums[i+l-1];
                    if (dp[i] == k){
                        res++;
                    }
                }else{
                    break;
                }
            }
        }

        return res;
    }

    public int subarraySumV2(int[] nums, int k){
        int pre = 0; //记录从0到下标为i的数的和
        int count = 0; //记录多少种结果
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //初始化一个和为0的记录

        for (int i=0; i<nums.length; i++){
            pre += nums[i];
            if (map.containsKey(pre - k)){
                //满足条件则说明存在一个下标j，使得j到i的zhi
                count += map.get(pre - k);
            }
            //一定要放在if判断后面put，否则会出现重复判断
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;
    }
}
