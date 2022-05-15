package com.company.algorithms;

import sun.lwawt.macosx.CSystemTray;

import java.util.*;

public class FindMinHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges){
        if (n == 0){
            return new ArrayList<>();
        }else if(n == 1){
            return Arrays.asList(0);
        }

        List<Integer> res = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> relatives = new HashMap<>();

        for (int[] edge: edges){
            //双向连接
            if (!relatives.containsKey(edge[0])){
                ArrayList<Integer> nextNodes = new ArrayList<>();
                nextNodes.add(edge[1]);
                relatives.put(edge[0], nextNodes);
            }else{
                relatives.get(edge[0]).add(edge[1]);
            }

            if (!relatives.containsKey(edge[1])){
                ArrayList<Integer> nextNodes = new ArrayList<>();
                nextNodes.add(edge[0]);
                relatives.put(edge[1], nextNodes);
            }else{
                relatives.get(edge[1]).add(edge[0]);
            }
        }

        int min = n-1;
        for (int i=0; i<n; i++){
            //尝试下0...n-1之间的所有节点为根节点的情况
            int[] visited = new int[n];
            LinkedList<int[]> queue = new LinkedList<>();
            queue.addLast(new int[]{i, 0});
            visited[i] = 1;

            int height = 0;
            while (!queue.isEmpty()){
                int[] node = queue.removeFirst();

                height = Math.max(node[1], height);

                for (int r: relatives.get(node[0])){
                    if (visited[r] == 0){
                        queue.addLast(new int[]{r, node[1]+1});
                        visited[node[0]] = 1;
                    }
                }
            }

            if (height == min){
                res.add(i);
            }else if(height < min){
                min = height;
                res.clear();
                res.add(i);
            }
        }

        return res;
    }
}
