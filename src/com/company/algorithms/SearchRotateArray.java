package com.company.algorithms;

public class SearchRotateArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int middle = (left + right)/2;
            if (nums[middle] == target){
                return middle;
            }

            if (nums[left] <= nums[middle]){
                //左侧是顺序数组
                if (nums[left] <= target && nums[middle] >= target){
                    //target在左侧的顺序数组中
                    right = middle - 1;
                }else{
                    left = middle + 1;
                }
            }else{
                //右侧
                if (nums[middle] <= target && nums[right] >= target){
                    //target在右侧的顺序数组中
                    left = middle + 1;
                }else{
                    right = middle - 1;
                }
            }
        }

        return -1;
    }
}
