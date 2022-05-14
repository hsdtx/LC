package com.company.swordoffer;

public class FindNthDigit {

    /**
     * 时间复杂度nlog10n，会超时
     */
    public int findNthDigit(int n){
        int index = 0, digitNum = 0;
        while (digitNum < n){
            digitNum += index/10+1;
            index++;
        }

        //把数复原到上一步
        index--;
        return (int) (index%(Math.pow(10, (digitNum-n)+1)));
    }

}
