package com.company.algorithms;

import java.util.LinkedList;

public class MaxSlidingWindow {

    /**
     * 单调队列，时间复杂度O(n)，空间复杂度O(n)
     */
    public int[] queue(int[] nums, int k){
        int[] res = new int[nums.length-k+1];
        LinkedList<Integer> queue = new LinkedList<>();

        //初始化，先把前k个数塞到队列里
        for (int i=0; i<k; i++){
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
        }
        res[0] = nums[queue.getFirst()];

        //滑动窗口开始移动
        for (int i=k; i<nums.length; i++){
            while (!queue.isEmpty() && (queue.getFirst() < i-k+1 || queue.getFirst() > i)){
                queue.removeFirst();
            }

            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
            res[i-k+1] = nums[queue.getFirst()];
        }

        return res;
    }
}
