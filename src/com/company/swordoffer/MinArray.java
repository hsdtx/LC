package com.company.swordoffer;

public class MinArray {

    /**
     * 二分查找
     */
    public int minArray(int[] numbers){
        int left = 0, right = numbers.length-1;
        int middle;
        while (left <= right){
            middle = (left+right)/2;
            if (numbers[middle] < numbers[right]){
                right = middle; //middle小于最右边的值时，不能排除middle不是最小值，新的区间需要包括middle
            }else if (numbers[middle] > numbers[right]){
                left = middle+1; //middle大于最右值，那它一定不是最小值，排除middle
            }else{
                right --; //不能确定新区间在middle左边还是右边，可以确定得是numbers[right]一定不是最小值，就算他的数值是最小值，左边也一定有和他一样的数
            }
        }

        //为什么是left呢，最后一轮进while，left = right = middle，但是right一定会减一，所以实际上left就是middle
        return numbers[left];
    }
}
