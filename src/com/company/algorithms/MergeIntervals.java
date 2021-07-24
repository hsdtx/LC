package com.company.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0] && o1[1] == o2[1])
                    return 0;
                else if((o1[0] == o2[0] && o1[1] < o2[1]) || o1[0] < o2[0])
                    return -1;
                else
                    return 1;
            }
        });
        for (int[] i: intervals){
            System.out.println(Arrays.toString(i));
        }

        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++){
            if (i == 0){
                res.add(intervals[0]);
                continue;
            }

            System.out.println(res.get(res.size()-1)[1] + " " + intervals[i][0] + "\n");
            if (res.get(res.size()-1)[1] >= intervals[i][0]){
                int[] temp = res.get(res.size()-1);
                temp[1] = Math.max(intervals[i][1], res.get(res.size()-1)[1]);
                res.set(res.size()-1, temp);
            }else{
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    /**
     * 根据区间的开头快排
     * TODO: 快排实现有问题
     * @param intervals
     * @return
     */
    private void quickSort(int[][] intervals, int begin, int end){
        if (begin >= end) return ;

        int i = begin + 1, j = end;
        while (i <= j){
            if (intervals[i][0] < intervals[begin][0]){
                i++;
            }else if(intervals[j][0] > intervals[begin][0]){
                j--;
            }else if(intervals[i][0] == intervals[begin][0] && intervals[i][1] <= intervals[begin][1]){
                i++;
            }else if(intervals[i][0] == intervals[begin][0] && intervals[i][1] > intervals[begin][1]){
                j--;
            } else{
                swap(intervals, i, j);
            }
        }

        swap(intervals, j, begin);
        quickSort(intervals, begin, j-1);
        quickSort(intervals, j+1, end);
    }

    private void swap(int[][] intervals, int i, int j){
        int temp0 = intervals[i][0];
        int temp1 = intervals[i][1];

        intervals[i][0] = intervals[j][0];
        intervals[i][1] = intervals[j][1];
        intervals[j][0] = temp0;
        intervals[j][1] = temp1;
    }
}
