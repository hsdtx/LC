package com.company.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CombinationSum {

    /**
     * 动态规划
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());

        for (int i=1; i<=target; i++){
            List<List<Integer>> newValue = new ArrayList<>();
            for (int num: candidates){
                if (i - num >= 0){
                    List<List<Integer>> listOfList = dp.get(i-num);
                    if (listOfList.isEmpty() && i-num == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(num);
                        newValue.add(temp);
                    } else{
                        for (int j=0; j<listOfList.size(); j++){
                            List<Integer> list = listOfList.get(j);
                            if (num >= list.get(list.size()-1)){
                                List<Integer> temp = new ArrayList<>(list);
                                temp.add(num);
                                newValue.add(temp);
                            }
                        }
                    }
                }
            }
            dp.add(newValue);
        }
//        System.out.println(dp.toString());

        return dp.get(target);
    }
}
