package com.company.swordoffer;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {

    public int v1(String s){
        HashSet<Character> window = new HashSet<>();
        int left = 0, right = 0, len = s.length(), max = 1;
        while (left < len && right < len){
            if (window.isEmpty() || !window.contains(s.charAt(right))){
                window.add(s.charAt(right++));
            }else{
                window.remove(s.charAt(left++));
            }

            max = Math.max(window.size(), max);
        }

        return max;
    }
}
