package com.company.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permute {
    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i: nums){
            set.add(i);
        }

        dfs(set, new ArrayList<>());
        return res;
    }

    private void dfs(HashSet<Integer> set, ArrayList<Integer> subRes){
        if (set.isEmpty()){
            res.add(new ArrayList<>(subRes));
        }

        Object[] list = set.toArray();
        for (Object o: list){
            int i = (int)o;
            subRes.add(i);
            set.remove(i);
            dfs(set, subRes);
            set.add(i); //回溯
            subRes.remove(subRes.size()-1);
        }
    }
}
