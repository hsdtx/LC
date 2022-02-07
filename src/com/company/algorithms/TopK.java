package com.company.algorithms;

import java.util.Arrays;

public class TopK {

    public int findKthLargest(int[] nums, int k) {
        int partitionRes = -1, left = 0, right = nums.length-1, target = nums.length-k;
        while (partitionRes != target){
            if (partitionRes < target){
                left = partitionRes + 1;
            }else{
                right = partitionRes - 1;
            }

//            System.out.println(left + " " + right );
            partitionRes = partition(nums, left, right);
        }

        return nums[target];
    }

    public int partition(int[] nums, int left, int right){

        int initial = left;
        int mark = nums[left]; //标记下要分割序列的值

        while(left < right){
            while (left < right && nums[right] >= mark){
                right--;
            }

            while (left < right && nums[left] <= mark){
                left ++;
            }

            swap(nums, left, right);
        }

        swap(nums, left, initial);
        return left;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}