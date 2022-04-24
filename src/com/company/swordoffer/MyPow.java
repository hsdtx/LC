package com.company.swordoffer;

public class MyPow {

    /**
     * 时间复杂度O(n)，较高，通过不了
     */
    public double v1(double x, int n){
        if(n < 0){
            n = -n;
            x = 1/x;
        }

        double res = 1;
        for (int i=0; i<n; i++){
            res *= x;
        }

        return res;
    }

    /**
     * 递归，时间复杂度O(logN)
     */
    public double v2(double x, int n){
        if (n == 0){
            return 1;
        }else if(n == 1){
            return x;
        }else if(n == -1){
            return 1/x;
        }

        if (n % 2 == 0){
            double temp = v2(x, n/2);
            return temp * temp;
        }

        int i = n/2;
        int j = n<0? i-1: i+1;
        return v2(x, i) * v2(x, j);
    }

}
