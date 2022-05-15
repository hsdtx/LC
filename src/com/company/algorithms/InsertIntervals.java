package com.company.algorithms;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
    
    public int[][] v1(int[][] intervals, int[] newInterval){

        boolean isInsert = false;
        List<int[]> res = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            if(newInterval[0] <= intervals[i][0]){
                if(!res.isEmpty() && res.get(res.size()-1)[1] >= newInterval[0]){
                    int[] lastItem = res.get(res.size()-1);
                    lastItem[1] = Math.max(lastItem[1], newInterval[1]);
                }else{
                    res.add(newInterval);
                }
                isInsert = true;
            }

            if(!res.isEmpty() && res.get(res.size()-1)[1] >= intervals[i][0]){
                int[] newLastItem = res.get(res.size()-1);
                newLastItem[1] = Math.max(newLastItem[1], intervals[i][1]);
            }else{
                res.add(intervals[i]);
            }
        }

        if(!isInsert){
            if(!res.isEmpty() && res.get(res.size()-1)[1] >= newInterval[0]){
                int[] newLastItem = res.get(res.size()-1);
                newLastItem[1] = Math.max(newLastItem[1], newInterval[1]);
            }else{
                res.add(newInterval);
            }
        }

        return res.toArray(new int[][]{});
    }
}
