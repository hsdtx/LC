package com.company.swordoffer;

import java.util.LinkedList;
import java.util.Queue;

public class MovingCount {

    public int v1(int m, int n, int k){
        //以长的为宽，利用对称性质
        if (m > n){
            int temp = n;
            n = m;
            m = temp;
        }

        int[][] visited = new int[m][n];
        int count = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{0, 0});
        while (!queue.isEmpty()){
            int[] node = queue.removeFirst();
            if (node[0] > node[1] ||
                    node[0] < 0 ||
                    node[0] >= m ||
                    node[1] >= n ||
                    visited[node[0]][node[1]] == 1 ||
                    getSum(node[0]) + getSum(node[1]) > k){
                continue;
            }

            visited[node[0]][node[1]] = 1;
            count++;
            if (node[0] != node[1] && node[1] < m){
                visited[node[1]][node[0]] = 1;
                count++;
            }

            queue.addLast(new int[]{node[0]+1, node[1]});
            queue.addLast(new int[]{node[0], node[1]+1});
        }

        return count;
    }

    public int getSum(int num){
        int sum = 0;
        while (num != 0){
            sum += (num%10);
            num /= 10;
        }

        return sum;
    }

}
