package com.company.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class CountSubstrings {

    public int countSubstrings(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        int cnt = 0;
        for (int i=0; i<len; i++){
            /*
             * 奇数
             */
            for (int left = i, right = i; left >= 0 && right < len; left--, right++){
                if (chs[left] == chs[right]){
                    cnt++;
                }else{
                    break;
                }
            }

            /*
             * 偶数
             */
            for (int left = i, right = i+1; left >= 0 && right < len; left--, right++){
                if (chs[left] == chs[right]){
                    cnt++;
                }else{
                    break;
                }
            }
        }

        return cnt;
    }
}
