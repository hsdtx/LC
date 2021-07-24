package com.company.algorithms;

import java.util.HashSet;

public class LongestNonReplicatedSubsequence {

    /**
     * 暴力解法
     * @param s
     * @return
     */
    public int longestNonReplicatedSubsequence(String s){
        char[] sequence = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int longest = 0;
        int temp = 0;
        for (int i = 0; i < sequence.length; i++){
            set.clear();
            temp = 0;
            for (int j = i; j < sequence.length; j++){
                if (!set.contains(sequence[j])){
                    set.add(sequence[j]);
                    temp++;
                }else{
                    if (longest < temp){
                        longest = temp;
                    }
                    set.clear();
                    set.add(sequence[j]);
                    temp = 0;
                }
            }

            if (longest < temp){
                longest = temp;
            }
        }

        return longest;
    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int longestNonReplicatedSubsequenceV2(String s){
        char[] sequence = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int longest = 0;

        for (int left = 0, right = -1; left < sequence.length; left++){
            //左指针滑动，把左指针左边的字符从set中移除
            if (left >= 1){
                set.remove(sequence[left - 1]);
            }

            //滑动右指针，右指针指向的字符如果不在set中，则增加，并继续滑动，直到到达字符串最后或出现重复字符
            while (right + 1 < sequence.length && !set.contains(sequence[right + 1])){
                set.add(sequence[right + 1]);
                right++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return  longest;
    }

}
