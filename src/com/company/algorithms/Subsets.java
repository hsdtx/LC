package com.company.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());

        while (!queue.isEmpty()){
            List<Integer> list = queue.removeFirst();
            res.add(new ArrayList<>(list));
            for (int n: nums){
                if (list.size() == 0 || list.get(list.size()-1) < n){
                    list.add(n);
                    queue.add(new ArrayList<>(list));
                    list.remove(list.size()-1);
                }
            }
        }

        return res;
    }

}
