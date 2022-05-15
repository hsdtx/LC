package com.company.algorithms;

public class CountBits {

    public int[] countBits(int n){
        int[] l = new int[n+1];
        for (int i=0; i<=n; i++){
            int temp = 0;
            int num = i;
            while (num!=0){
                if ((num&1) == 1){
                    temp++;
                }
                num = num>>1;
            }
            l[i] = temp;
        }

        return l;
    }

    public int[] v1(int n){
        if (n==0){
            return new int[]{0};
        }

        int[] l = new int[n+1];
        l[1] = 1; //初始化一下，实际上是l[0]=0，l[1]=1
        for (int i=0; i<=n; i++){
            l[i] = l[i>>1]+((i&1)==1? 1:0);
        }
        return l;
    }
}
