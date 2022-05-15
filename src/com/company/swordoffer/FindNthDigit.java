package com.company.swordoffer;

public class FindNthDigit {

    public int v1(int n){
        if (n== 0) return 0;

        int index=1, digitNum=0;
        while (digitNum < n){
            int tempDigit = 0, tempIndex = index;
            while (tempIndex > 0){
                tempIndex /= 10;
                tempDigit ++;
            }
            digitNum += tempDigit;
            index++;
        }

        //index复原
        index--;
        int res = 0;
        for (int i=0; i<=digitNum-n; i++){
            res = index%10;
            index /= 10;
        }

        return res;
    }
}
