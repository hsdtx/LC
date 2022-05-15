package com.company.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class CanFinish{
 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> relatives = new HashMap<>();
        for(int[] prerequisite: prerequisites){
            //记录所有节点的入度
            inDegree[prerequisite[1]] ++; //入度+1

            //记录所有节点的联系关系
            if(relatives.get(prerequisite[0]) == null){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(prerequisite[1]);
                relatives.put(prerequisite[0], list);
            }else{
                relatives.get(prerequisite[0]).add(prerequisite[1]);
            }
        }

        LinkedList<Integer> stack = new LinkedList<>();
        //初始化数据
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0){
                stack.addFirst(i);
            }
        }

        while(!stack.isEmpty()){
            int start = stack.removeFirst();
            if(relatives.get(start) == null || relatives.get(start).size() == 0){
                continue;
            }else{
                ArrayList<Integer> ends = relatives.get(start);
                for(int end: ends){
                    inDegree[end] --;
                    if(inDegree[end] == 0){
                        stack.addFirst(end);
                    }
                }
            }
        }

        boolean res = true;
        for(int in: inDegree){
            if(in>0){
                res = false;
                break;
            }
        }

        return res;
    }
}