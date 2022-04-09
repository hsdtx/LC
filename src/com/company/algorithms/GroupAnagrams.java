package com.company.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str: strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            if (map.get(key) == null){
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(key, temp);
            }else{
                map.get(key).add(str);
            }
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> optimize(String[] strs){
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str: strs){
            //用计数代替排序，这个地方的时间复杂度会提升些，O(nlogn) -> O(n)
            int[] count = new int[26]; //26个字母
            for (int i=0; i<str.length(); i++){
                count[(int)(str.charAt(i) - 'a')] ++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<count.length; i++){
                for (int j=0; j<count[i]; j++){
                    sb.append('a' + i);
                }
            }

            String key = sb.toString();
            if (map.get(key) == null){
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(key, temp);
            }else{
                map.get(key).add(str);
            }
        }

        return new ArrayList<>(map.values());
    }
}
