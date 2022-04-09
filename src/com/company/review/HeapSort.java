package com.company.review;

public class HeapSort {

    public void sort(int[] nums){
        if (nums == null || nums.length <= 1){
            return;
        }

        int len = nums.length;
        buildLargeHeap(nums, len);

        for (; len>= 1; len--){
            swap(nums, 0, len-1);
            heapify(nums, len-1, 0);
        }
    }

    private void buildLargeHeap(int[] nums, int len){
        int lastNonLeafIndex = len/2-1; //最后一个非叶子节点
        for (; lastNonLeafIndex>=0; lastNonLeafIndex--){
            heapify(nums, len, lastNonLeafIndex);
        }
    }

    private void heapify(int[] nums, int len, int index){
        int left = index*2+1; //左子节点
        int right = index*2+2; //右子节点

        int largestIndex = index;
        if (left < len && nums[left] > nums[largestIndex]){
            largestIndex = left;
        }

        if (right < len && nums[right] > nums[largestIndex]){
            largestIndex = right;
        }

        //如果父节点不满足子节点都小于自己，则调整
        if (index != largestIndex){
            swap(nums, largestIndex, index);

            heapify(nums, len, largestIndex);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
