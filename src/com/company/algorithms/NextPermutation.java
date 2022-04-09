package com.company.algorithms;

public class NextPermutation {

    public void nextPermutation(int[] nums) {

        if (nums.length <= 1){
            return ;
        }

        /*
         * 找出下标i，使nums(i+1...n)为降序序列
         */
        int i=nums.length-2;
        for (; i>=-1; i--){
            if (i == -1 ){
                break;
            }

            if (nums[i] < nums[i+1]){
                break;
            }
        }

        if (i != -1){
            /*
             * 找出降序序列里大于nums[i]的最小值
             */
            int j=nums.length-1;
            for (; j>=0; j--){
                if (nums[j] > nums[i]){
                    break;
                }
            }

            /*
             * 交换下标i，j对应的数值
             */
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        /*
         * 将nums(i+1...n)由逆序变为升序
         */
        int otherTemp;
        int otherIndex;
        for (int x=i+1; x<=(i+1+nums.length-1)/2; x++){
            otherTemp = nums[x];
            otherIndex = nums.length-1-(x-i-1);
            nums[x] = nums[otherIndex];
            nums[otherIndex] = otherTemp;
        }
    }
}
