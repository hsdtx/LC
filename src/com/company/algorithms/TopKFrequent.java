package com.company.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k){
        int[] res = new int[k];
        HashMap<Integer, Integer> frequent = new HashMap<>();
        for (int n: nums){
            frequent.put(n, frequent.getOrDefault(n, 0)+1);
        }

        List<Integer> onlyFrequent = new ArrayList<>(frequent.values());
        System.out.println(onlyFrequent);
        int start = 0;
        int end = onlyFrequent.size()-1;
        int tempK = -1;
        while (onlyFrequent.size()-tempK != k){
            tempK = partition(onlyFrequent, start, end);
            System.out.println(tempK);

            if (onlyFrequent.size()-tempK > k){
                start = tempK+1;
            }else if(onlyFrequent.size()-tempK < k){
                end = tempK-1;
            }
        }
        int topKFrequent = onlyFrequent.get(tempK);
        int resIndex = 0;
        for (int key: frequent.keySet()){
            if (frequent.get(key) >= topKFrequent){
                res[resIndex] = key;
                resIndex++;
            }
        }

        return res;
    }

    public int partition(List<Integer> list, int start, int end){
        int mark = list.get(start);
        int markIndex = start;
        start++;
        while (start <= end){
            if (list.get(start) > mark && list.get(end) < mark){
                swap(list, start, end);
            }

            if (list.get(start) <= mark){
                start++;
            }

            if (list.get(end) >= mark){
                end--;
            }
        }
        swap(list, markIndex, end);

        return end;
    }

    private void swap(List<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}