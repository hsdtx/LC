package com.company.algorithms;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        if (x == y) return 0;

        int ret = 0;
        while (x != 0 || y != 0){
            int xx = x % 2; //x二进制数
            int yy = y % 2;

            if (xx != yy){
                ret ++;
            }

            x = x/2;
            y = y/2;
        }

        return ret;
    }
}