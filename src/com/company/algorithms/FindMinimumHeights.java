package com.company.algorithms;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class FindMinimumHeights {

    public List<Integer> findMinimumHeights(int n, int[][] edges){
        if (n == 0){
            return Arrays.asList(0);
        }

        //transfer edges to x->y array
        ArrayList<Integer>[] relatives = new ArrayList[n];
        for (int[] edge: edges){
            if (relatives[edge[0]] == null){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                relatives[edge[0]] = list;
            }else{
                relatives[edge[0]].add(edge[1]);
            }

            if (relatives[edge[1]] == null){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(edge[0]);
                relatives[edge[1]] = list;
            }else{
                relatives[edge[1]].add(edge[0]);
            }
        }

        int[] parent = new int[n];
        int x = findFarNode(0, parent, relatives);
        Arrays.fill(parent, -1); //默认值
        int y = findFarNode(x, parent, relatives);

        ArrayList<Integer> path = new ArrayList<>();
        int curr = y;
        while (curr != -1){
            path.add(curr);
            curr = parent[curr];
        }

        if (path.size()%2 == 0){
            int index = path.size()/2;
            return Arrays.asList(path.get(index), path.get(index-1));
        }

        int index = path.size()/2;
        return Arrays.asList(path.get(index));
    }

    private int findFarNode(int start, int[] parent, ArrayList<Integer>[] relatives){
        LinkedList<Integer> queue = new LinkedList<>();
        int[] visited = new int[relatives.length];
        queue.addLast(start);
        visited[start] = 1;
        int target = start;

        while (!queue.isEmpty()){
            int node = queue.removeFirst();
            visited[node] = 1;
            for (int nextNode: relatives[node]){
                if (visited[nextNode] == 0){
                    queue.addLast(nextNode);
                    target = nextNode; //BFS 最后遍历到的节点就是最远的节点
                    parent[nextNode] = node; //记录每个节点的父节点
                }
            }
        }

        return target;
    }
}
