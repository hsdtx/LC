package com.company.algorithms;

public class RemoveElement {

    /**
     * 直接冒泡，用时竟然超过了100%...
     */
    public int removeElement(int[] nums, int val) {
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                //满足以下两个条件代表i位的数不是val
                if (nums[i] == val && nums[j] != val){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int i=0; i< nums.length; i++){
            if (nums[i] == val){
                return i;
            }
        }

        return nums.length;
    }

    /**
     * LeetCode官方解法，没必要用冒泡那种方式，直接简单把不等于val的元素往左边挪就行了
     */
    public int removeElementV2(int[] nums, int val){
        if (nums.length == 0){
            return 0;
        }

        int left = 0, right = 0;
        while (left < nums.length && right < nums.length){
            if (nums[right] != val){
                //如果右指针不是val，就往右移，然后看下一个元素是不是val
                nums[left] = nums[right];
                left++;
                right++; //左右指针均往右移
            }

            right++;//仅右指针移动
        }

        return left;
    }
}
