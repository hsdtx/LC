package com.company.swordoffer;

public class MinArray {

    /**
     * 二分查找
     * 找到最小值前面那个数，有个特殊情况数组并没有发生旋转，这时候最小值前面那个数的下标是-1
     */
    public int v1(int[] numbers){
        int len = numbers.length;
        int left = 0, right = len-1;
        int middle = (left+right)/2;
        while (left <= right && (middle < 1 || numbers[middle] >= numbers[middle-1])){
            if (numbers[middle] > numbers[len-1]){
                left = middle + 1;
            }else if(numbers[middle] < numbers[len-1]) {
                right = middle - 1;
            }else {
                right --;
            }

            middle = (left+right)/2;
        } 

        return numbers[middle];
    }
}
