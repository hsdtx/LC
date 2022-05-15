package com.company.algorithms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p){
        int sLength = s.length(), pLength = p.length();

        List<Integer> list = new ArrayList<>();
        if (pLength > sLength){
            return list;
        }

        int[] sCount = new int[26]; //26个字母
        int[] pCount = new int[26];
        for (int i=0; i<pLength; i++){
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sCount, pCount)){
            list.add(0);
        }
        sCount[s.charAt(0) - 'a']--;

        for (int i=1; i<=sLength-pLength; i++){
            sCount[s.charAt(i+pLength-1) - 'a']++;
            if (Arrays.equals(sCount, pCount)){
                list.add(i);
            }
            sCount[s.charAt(i) - 'a']--;
        }

        return list;
    }
}
