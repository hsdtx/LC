package com.company.algorithms;

import java.util.HashSet;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int n: nums){
            set.add(n);
        }

        int longestLength = 0;
        for (int n: set){
            //判断一下n是否可以作为连续序列的开头
            if (!set.contains(n-1)){
                int currentValue = n;
                int currentLength = 1;

                while (set.contains(currentValue+1)){
                    currentValue = currentValue+1;
                    currentLength++;
                }

                longestLength = Math.max(longestLength, currentLength);
            }
        }

        return longestLength;
    }
}
