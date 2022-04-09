package com.company.algorithms;

import java.util.Arrays;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] leftProduct = new int[len];
        int[] rightProduct = new int[len];
        int[] res = new int[len];

        for (int i=0; i<len; i++){
            if (i == 0){
                //左边没有值，用1做默认值
                leftProduct[i] = 1;
            }else{
                leftProduct[i] = leftProduct[i-1]*nums[i-1];
            }
        }

        for (int i=len-1; i>=0; i--){
            if (i == len-1){
                rightProduct[i] = 1;
            }else{
                rightProduct[i] = rightProduct[i+1]*nums[i+1];
            }
        }

        for (int i=0; i<len; i++){
            res[i] = leftProduct[i]*rightProduct[i];
        }

        return res;
    }

    /**
     * 观察上面的方法其实可见，有数组和循环是可以复用的
     */
    public int[] optimization(int[] nums){
        int len = nums.length;
        int[] ans = new int[len];

        for (int i=0; i<len; i++){
            if (i==0){
                ans[i] = 1;
            }else{
                ans[i] = ans[i-1]*nums[i-1];
            }
        }

        int rightProduct = 1;
        for (int i=len-1; i>=0; i--){
            ans[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return ans;
    }
}