package com.company.swordoffer;

public class FindRepeatNumbers {

    /**
     * 简单思路，对每个数计数
     */
    public int v1(int[] nums){
        int len = nums.length;
        int[] count = new int[len];

        for (int n: nums){
            count[n]++;

            if (count[n] > 1){
                return n;
            }
        }

        return -1;
    }

    /**
     * 在简单计数的基础上，做优化，去除额外空间的使用，对原数组做修改以达到计数的效果
     */
    public int v2(int[] nums){
        int len = nums.length;

        for (int i=0; i<len; i++){
            int original = nums[i]%len;
            nums[original] += len;
            int count = nums[original]/len;

            if (count > 1){
                return original;
            }
        }

        return -1;
    }
}
