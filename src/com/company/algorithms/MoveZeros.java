package com.company.algorithms;

public class MoveZeros {

    public void moveZeros(int[] nums){
        int len = nums.length;
        if (len < 2){
            return;
        }

        int left = 0, right = 1;
        while (left < len && right < len){
            if (nums[left] == 0 && nums[right] == 0){
                right++;
            }else if(nums[left] == 0){
                swap(nums, left, right);
            }else {
                left++;
                right++;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
