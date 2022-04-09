package com.company.algorithms;

import java.util.ArrayList;
import java.util.HashSet;

public class CountArrangement {

    public int countArrangement(int n) {
        HashSet<Integer> set = new HashSet<>();
        for (int i=1; i<=n; i++){
            set.add(i);
        }

        return dfs(set, 1, n);
    }

    private int dfs(HashSet<Integer> set, int current, int n){
        if (current > n){
            return 1;
        }

        int ret = 0;
        for (Object o: set.toArray()){
            int i = (int)o;
            System.out.println(i);
            //剪枝
            if (i % current == 0 || current % i == 0){
                continue;
            }
            System.out.println(i);

            set.remove(i);
            ret += dfs(set, current+1, n) + 1;
            set.add(i); //回溯
        }

        return ret;
    }
}
