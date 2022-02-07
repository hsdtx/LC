package com.company.algorithms;

public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, left = -1;
        int min = Integer.MAX_VALUE, right = -1;

        for (int i=0; i<n; i++){
            if (nums[i] >= max){
                max = nums[i];
            }else{
                right = i; //找到最后一个小于左侧最大值的坐标
            }
        }

        for (int i=n-1; i>=0; i--){
            if (nums[i] <= min){
                min = nums[i];
            }else{
                left = i;
            }
        }

        return left == -1? 0: right-left+1;
    }
}
