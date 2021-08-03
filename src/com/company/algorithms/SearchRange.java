package com.company.algorithms;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int minIndex = getTargetIndex(nums, target, true);
        int maxIndex = getTargetIndex(nums, target, false);
        return new int[]{minIndex, maxIndex};
    }

    public int getTargetIndex(int[] nums, int target, boolean min){
        int i = 0;
        int j = nums.length - 1;
        int tempIndex = -1;
        while (i<=j){
            int index = (i+j)/2;
            if (nums[index] > target){
                j = index - 1;
            }else if(nums[index] < target){
                i = index + 1;
            }else{
                tempIndex = index;
                if (min){
                    j = index - 1;
                    System.out.println(j);
                }else {
                    i = index + 1;
                }
            }
        }

        return tempIndex;
    }
}
