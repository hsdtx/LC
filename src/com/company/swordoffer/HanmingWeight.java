package com.company.swordoffer;

public class HanmingWeight {

    public int hanmingWeight(int n){
        int count = 0;
        while (n != 0){
            count += (n&1);
            n = n>>>1;
        }

        return count;
    }
}
